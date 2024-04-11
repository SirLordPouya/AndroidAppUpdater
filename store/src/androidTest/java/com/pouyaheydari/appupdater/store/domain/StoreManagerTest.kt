package com.pouyaheydari.appupdater.store.domain

import android.content.ActivityNotFoundException
import android.content.Context
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pouyaheydari.androidappupdater.store.domain.ShowStoreModel
import com.pouyaheydari.androidappupdater.store.domain.showAppInSelectedStore
import com.pouyaheydari.androidappupdater.store.domain.stores.GooglePlayStore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@RunWith(AndroidJUnit4::class)
class StoreManagerTest {
    @get:Rule
    val intentsTestRule = IntentsRule()

    @Test
    fun test_showAppInSelectedStore_sendsCorrectIntent() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val packageName = "PackageName"
        val store = GooglePlayStore(packageName)
        val storeModel = ShowStoreModel(store = store, errorCallBack = {})

        showAppInSelectedStore(appContext, storeModel)

        Intents.intended(IntentMatchers.filterEquals(store.getIntent()))
    }

    @Test
    fun test_showAppInSelectedStore_storeNotInstalled_invokesErrorCallback() {
        val callback: (String) -> Unit = mock()
        val storeModel = ShowStoreModel(store = GooglePlayStore("PackageName"), errorCallBack = callback)
        val context: Context = mock()
        whenever(context.startActivity(any())).thenThrow(ActivityNotFoundException::class.java)

        showAppInSelectedStore(context, storeModel)

        verify(callback).invoke(any())
    }
}
