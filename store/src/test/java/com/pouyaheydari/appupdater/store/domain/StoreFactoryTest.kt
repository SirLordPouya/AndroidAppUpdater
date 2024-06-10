package com.pouyaheydari.appupdater.store.domain

import com.pouyaheydari.appupdater.store.domain.stores.AmazonAppStore
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType
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
    fun `whenever getStore with GooglePlay parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = GooglePlayStore(packageName)

        val result = StoreFactory.getStore(AppStoreType.GOOGLE_PLAY, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with Amazon parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = AmazonAppStore(packageName)

        val result = StoreFactory.getStore(AppStoreType.AMAZON_APP_STORE, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with Aptiode parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = Aptoide(packageName)

        val result = StoreFactory.getStore(AppStoreType.APTOIDE, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with CafeBazaar parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = CafeBazaarStore(packageName)

        val result = StoreFactory.getStore(AppStoreType.CAFE_BAZAAR, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with Fdroid parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = FDroid(packageName)

        val result = StoreFactory.getStore(AppStoreType.FDROID, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with AppGallery parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = HuaweiAppGallery(packageName)

        val result = StoreFactory.getStore(AppStoreType.HUAWEI_APP_GALLERY, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with LenovoAppCenter parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = LenovoAppCenter(packageName)

        val result = StoreFactory.getStore(AppStoreType.LENOVO_APP_CENTER, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with MiStore parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = MiGetAppStore(packageName)

        val result = StoreFactory.getStore(AppStoreType.MI_GET_APP_STORE, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with Myket parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = MyketStore(packageName)

        val result = StoreFactory.getStore(AppStoreType.MYKET, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with NineApps parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = NineApps(packageName)

        val result = StoreFactory.getStore(AppStoreType.NINE_APPS_STORE, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with OneStore parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = OneStoreAppMarket(packageName)

        val result = StoreFactory.getStore(AppStoreType.ONE_STORE_APP_MARKET, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with OppoMarket parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = OppoAppMarket(packageName)

        val result = StoreFactory.getStore(AppStoreType.OPPO_APP_MARKET, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with GalaxyStore parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = SamsungGalaxyStore(packageName)

        val result = StoreFactory.getStore(AppStoreType.SAMSUNG_GALAXY_STORE, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with TencentAppStore parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = TencentAppStore(packageName)

        val result = StoreFactory.getStore(AppStoreType.TENCENT_APPS_STORE, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with VAppStore parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = VAppStore(packageName)

        val result = StoreFactory.getStore(AppStoreType.V_APP_STORE, packageName)

        assertEquals(expected, result)
    }

    @Test
    fun `whenever getStore with ZTEAppStore parameter is called, then proper instance gets returned`() {
        val packageName = "PackageName"
        val expected = ZTEAppCenter(packageName)

        val result = StoreFactory.getStore(AppStoreType.ZTE_APP_CENTER, packageName)

        assertEquals(expected, result)
    }
}
