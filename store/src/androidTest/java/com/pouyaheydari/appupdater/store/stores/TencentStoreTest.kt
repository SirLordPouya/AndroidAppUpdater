package com.pouyaheydari.appupdater.store.stores

import android.net.Uri
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pouyaheydari.androidappupdater.store.ShowStoreModel
import com.pouyaheydari.androidappupdater.store.domain.StoreFactory
import com.pouyaheydari.androidappupdater.store.domain.showAppInSelectedStore
import com.pouyaheydari.androidappupdater.store.stores.TENCENT_APP_STORE_URL
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class TencentStoreTest {
    @get:Rule
    val intentsTestRule = IntentsRule()

    @Test
    fun whenCalling_setStoreData_then_intentGetsFiredCorrectly() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val packageName = appContext.packageName
        val url = "https://pouyaheydari.com"
        val tencentStoreModel = ShowStoreModel(StoreFactory.getTencentAppStore(packageName), url)

        showAppInSelectedStore(appContext, tencentStoreModel)

        Intents.intended(IntentMatchers.hasData(Uri.parse("$TENCENT_APP_STORE_URL$packageName")))
    }
}
