package com.pouyaheydari.appupdater.store.domain

import com.pouyaheydari.appupdater.store.domain.stores.AmazonAppStore
import com.pouyaheydari.appupdater.store.domain.stores.Aptoide
import com.pouyaheydari.appupdater.store.domain.stores.CafeBazaarStore
import com.pouyaheydari.appupdater.store.domain.stores.FDroid
import com.pouyaheydari.appupdater.store.domain.stores.GooglePlayStore
import com.pouyaheydari.appupdater.store.domain.stores.HuaweiAppGallery
import com.pouyaheydari.appupdater.store.domain.stores.LenovoAppCenter
import com.pouyaheydari.appupdater.store.domain.stores.MiGetAppStore
import com.pouyaheydari.appupdater.store.domain.stores.MyketStore
import com.pouyaheydari.appupdater.store.domain.stores.NineApps
import com.pouyaheydari.appupdater.store.domain.stores.OneStoreAppMarket
import com.pouyaheydari.appupdater.store.domain.stores.OppoAppMarket
import com.pouyaheydari.appupdater.store.domain.stores.SamsungGalaxyStore
import com.pouyaheydari.appupdater.store.domain.stores.TencentAppStore
import com.pouyaheydari.appupdater.store.domain.stores.VAppStore
import com.pouyaheydari.appupdater.store.domain.stores.ZTEAppCenter
import org.junit.Assert.assertEquals
import org.junit.Test

class StoreFactoryTest {
    @Test
    fun `whenever getGooglePlayStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = GooglePlayStore(packageName)

        val result = StoreFactory.getGooglePlayStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getAmazonAppStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = AmazonAppStore(packageName)

        val result = StoreFactory.getAmazonAppStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getAptoideStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = Aptoide(packageName)

        val result = StoreFactory.getAptoideStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getCafeBazaarStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = CafeBazaarStore(packageName)

        val result = StoreFactory.getCafeBazaarStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getFdroidStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = FDroid(packageName)

        val result = StoreFactory.getFdroidStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getHuaweiAppGalleryStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = HuaweiAppGallery(packageName)

        val result = StoreFactory.getHuaweiAppGalleryStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getLenovoAppCenterStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = LenovoAppCenter(packageName)

        val result = StoreFactory.getLenovoAppCenterStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getMiStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = MiGetAppStore(packageName)

        val result = StoreFactory.getMiStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getMyketStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = MyketStore(packageName)

        val result = StoreFactory.getMyketStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getNineAppsStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = NineApps(packageName)

        val result = StoreFactory.getNineAppsStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getOneStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = OneStoreAppMarket(packageName)

        val result = StoreFactory.getOneStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getOppoAppMarketStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = OppoAppMarket(packageName)

        val result = StoreFactory.getOppoAppMarketStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getSamsungGalaxyStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = SamsungGalaxyStore(packageName)

        val result = StoreFactory.getSamsungGalaxyStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getTencentAppStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = TencentAppStore(packageName)

        val result = StoreFactory.getTencentAppStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getVAppStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = VAppStore(packageName)

        val result = StoreFactory.getVAppStore(packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getZTEStore is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = ZTEAppCenter(packageName)

        val result = StoreFactory.getZTEStore(packageName)

        assertEquals(expected, result)
    }
}
