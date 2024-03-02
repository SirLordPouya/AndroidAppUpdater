package com.pouyaheydari.appupdater.store.stores

import android.net.Uri
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pouyaheydari.androidappupdater.store.domain.showAppInSelectedStore
import com.pouyaheydari.androidappupdater.store.model.ShowStoreModel
import com.pouyaheydari.androidappupdater.store.model.Store
import com.pouyaheydari.androidappupdater.store.stores.HUAWEI_APP_GALLERY_PACKAGE
import com.pouyaheydari.androidappupdater.store.stores.HUAWEI_APP_GALLERY_URL
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class HuaweiAppGalleryTest {
    @get:Rule
    val intentsTestRule = IntentsRule()

    @Test
    fun whenCalling_setStoreData_then_intentGetsFiredCorrectly() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val packageName = appContext.packageName
        val url = "https://pouyaheydari.com"
        val storeModel = ShowStoreModel(packageName, Store.HUAWEI_APP_GALLERY, url)

        showAppInSelectedStore(appContext, storeModel)

        Intents.intended(IntentMatchers.hasData(Uri.parse("$HUAWEI_APP_GALLERY_URL$packageName")))
        Intents.intended(IntentMatchers.hasPackage(HUAWEI_APP_GALLERY_PACKAGE))
    }
}
