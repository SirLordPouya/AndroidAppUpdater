package com.pouyaheydari.appupdater.core.stores

import android.net.Uri
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pouyaheydari.appupdater.core.data.model.ShowStoreModel
import com.pouyaheydari.appupdater.core.data.model.Store
import com.pouyaheydari.appupdater.core.utils.showAppInSelectedStore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class LenovoAppCenterTest {
    @get:Rule
    val intentsTestRule = IntentsRule()

    @Test
    fun whenCalling_setStoreData_then_intentGetsFiredCorrectly() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val packageName = appContext.packageName
        val url = "https://pouyaheydari.com"
        val storeModel = ShowStoreModel(packageName, Store.LENOVO_APP_CENTER, url)

        showAppInSelectedStore(appContext, storeModel)

        Intents.intended(IntentMatchers.hasData(Uri.parse("$LENOVO_APP_CENTER_URL$packageName")))
    }
}
