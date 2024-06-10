package com.pouyaheydari.appupdater.store.domain

import android.content.Intent
import android.net.Uri
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertThrows
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class StoreIntentBuilderTest {
    @Test
    fun `happy path`() {
        val uriString = "https://pouyaheydari.com"
        val packageName = "PackageName"

        val intent = StoreIntentBuilder.Builder(uriString).withPackage(packageName).build()

        assertEquals(Intent.ACTION_VIEW, intent.action)
        assertEquals(Intent.FLAG_ACTIVITY_NEW_TASK, intent.flags)
        assertEquals(packageName, intent.`package`)
        assertEquals(Uri.parse(uriString), intent.data)
    }

    @Test
    fun `whenever the uri is valid and no package name is provided, then the correct Intent is returned`() {
        val uriString = "https://pouyaheydari.com"

        val intent = StoreIntentBuilder.Builder(uriString).build()

        assertEquals(Intent.ACTION_VIEW, intent.action)
        assertEquals(Intent.FLAG_ACTIVITY_NEW_TASK, intent.flags)
        assertEquals(Uri.parse(uriString), intent.data)
        assertNull(intent.`package`)
    }

    @Test
    fun `whenever a blank package name is set, then IllegalArgumentException is thrown`() {
        val uriString = "https://pouyaheydari.com"
        val packageName = ""
        val builder = StoreIntentBuilder.Builder(uriString)

        assertThrows(IllegalArgumentException::class.java) {
            builder.withPackage(packageName)
        }
    }
}
