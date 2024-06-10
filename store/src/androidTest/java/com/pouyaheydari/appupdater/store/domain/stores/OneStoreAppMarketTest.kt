package com.pouyaheydari.appupdater.store.domain.stores

import android.net.Uri
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pouyaheydari.appupdater.store.domain.AppStoreCallback
import com.pouyaheydari.appupdater.store.domain.StoreFactory
import com.pouyaheydari.appupdater.store.domain.showAppInSelectedStore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class OneStoreAppMarketTest {
    @get:Rule
    val intentsTestRule = IntentsRule()

    @Test
    fun whenCalling_setStoreData_then_intentGetsFiredCorrectly() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val packageName = appContext.packageName
        val store = StoreFactory.getStore(AppStoreType.ONE_STORE_APP_MARKET, packageName)
        val errorCallback: (AppStoreCallback) -> Unit = {}

        showAppInSelectedStore(appContext, store, errorCallback)

        Intents.intended(IntentMatchers.hasData(Uri.parse("$ONE_STORE_APP_MARKET_URL$packageName")))
    }
}
