package com.pouyaheydari.appupdater.core.stores

import android.net.Uri
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pouyaheydari.appupdater.core.pojo.Store
import com.pouyaheydari.appupdater.core.pojo.StoreListItem
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class CafeBazaarStoreTest {
    @get:Rule
    val intentsTestRule = IntentsRule()

    @Test
    fun whenCalling_setStoreData_then_intentGetsFiredCorrectly() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val cafeBazaarStore = CafeBazaarStore()
        val packageName = appContext.packageName
        val url = "https://pouyaheydari.com"

        cafeBazaarStore.setStoreData(StoreListItem(store = Store.CAFE_BAZAAR, packageName = packageName, url = url))
        cafeBazaarStore.showStore(appContext)

        Intents.intended(IntentMatchers.hasPackage(BAZAAR_PACKAGE))
        Intents.intended(IntentMatchers.hasData(Uri.parse("$BAZAAR_URL$packageName")))
    }
}
