package com.pouyaheydari.appupdater.store.utils

import com.pouyaheydari.androidappupdater.store.model.Store
import com.pouyaheydari.androidappupdater.store.model.StoreListItem
import com.pouyaheydari.androidappupdater.store.shouldShowStoresDivider
import org.junit.Assert.assertEquals
import org.junit.Test

internal class StoreListUtilTest {
    @Test
    fun `when both lists are not empty, then shouldShowStoresDivider return true`() {
        val directDownloadList = listOf(StoreListItem(store = Store.DIRECT_URL))
        val storeList = listOf(StoreListItem(store = Store.GOOGLE_PLAY))

        val result = shouldShowStoresDivider(
            directDownloadList,
            storeList,
        )

        assertEquals(true, result)
    }

    @Test
    fun `when only direct download link is not empty, then shouldShowStoresDivider return false`() {
        val directDownloadList = listOf(StoreListItem(store = Store.DIRECT_URL))
        val storeList = listOf<StoreListItem>()

        val result = shouldShowStoresDivider(
            directDownloadList,
            storeList,
        )

        assertEquals(false, result)
    }

    @Test
    fun `when only app stores list is not empty, then shouldShowStoresDivider return false`() {
        val directDownloadList = listOf<StoreListItem>()
        val storeList = listOf(StoreListItem(store = Store.GOOGLE_PLAY))

        val result = shouldShowStoresDivider(
            directDownloadList,
            storeList,
        )

        assertEquals(false, result)
    }

    @Test
    fun `when both lists are empty, then shouldShowStoresDivider return false`() {
        val directDownloadList = listOf<StoreListItem>()
        val storeList = listOf<StoreListItem>()

        val result = shouldShowStoresDivider(
            directDownloadList,
            storeList,
        )

        assertEquals(false, result)
    }
}
