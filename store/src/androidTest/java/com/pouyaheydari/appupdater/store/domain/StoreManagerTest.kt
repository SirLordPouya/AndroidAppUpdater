package com.pouyaheydari.appupdater.store.domain

import android.content.ActivityNotFoundException
import android.content.Context
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.pouyaheydari.appupdater.store.domain.stores.GooglePlayStore
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
        val errorCallBack: (AppStoreCallback) -> Unit = {}

        showAppInSelectedStore(appContext, store, errorCallBack)

        Intents.intended(IntentMatchers.filterEquals(store.getIntent()))
    }

    @Test
    fun test_showAppInSelectedStore_storeNotInstalled_invokesErrorCallback() {
        val errorCallBack: (AppStoreCallback) -> Unit = mock()
        val store = GooglePlayStore("PackageName")
        val context: Context = mock()
        whenever(context.startActivity(any())).thenThrow(ActivityNotFoundException::class.java)

        showAppInSelectedStore(context, store, errorCallBack)

        verify(errorCallBack).invoke(any())
    }
}
