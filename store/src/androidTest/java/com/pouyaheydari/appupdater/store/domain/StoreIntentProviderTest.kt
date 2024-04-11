package com.pouyaheydari.appupdater.store.domain

import android.content.Intent
import android.net.Uri
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StoreIntentProviderTest {
    @Test
    fun test_happyPath() {
        val uriString = "https://pouyaheydari.com"
        val packageName = "PackageName"

        val intent = StoreIntentProvider.Builder(uriString).withPackage(packageName).build()

        assertEquals(Intent.ACTION_VIEW, intent.action)
        assertEquals(Intent.FLAG_ACTIVITY_NEW_TASK, intent.flags)
        assertEquals(packageName, intent.`package`)
        assertEquals(Uri.parse(uriString), intent.data)
    }

    @Test
    fun test_intentWithValidUriStringAndNoStorePackageName() {
        val uriString = "https://pouyaheydari.com"

        val intent = StoreIntentProvider.Builder(uriString).build()

        assertEquals(Intent.ACTION_VIEW, intent.action)
        assertEquals(Intent.FLAG_ACTIVITY_NEW_TASK, intent.flags)
        assertEquals(Uri.parse(uriString), intent.data)
        assertNull(intent.`package`)
    }

    @Test
    fun test_intentWithValidUriStringAndEmptyStorePackageNameThrowsException() {
        val uriString = "https://pouyaheydari.com"
        val packageName = ""
        val builder = StoreIntentProvider.Builder(uriString)

        assertThrows(IllegalArgumentException::class.java) {
            builder.withPackage(packageName)
        }
    }
}
