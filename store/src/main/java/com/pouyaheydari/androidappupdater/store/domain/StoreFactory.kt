package com.pouyaheydari.androidappupdater.store.domain

import com.pouyaheydari.androidappupdater.store.stores.AmazonAppStore
import com.pouyaheydari.androidappupdater.store.stores.Aptoide
import com.pouyaheydari.androidappupdater.store.stores.CafeBazaarStore
import com.pouyaheydari.androidappupdater.store.stores.FDroid
import com.pouyaheydari.androidappupdater.store.stores.GooglePlayStore
import com.pouyaheydari.androidappupdater.store.stores.HuaweiAppGallery
import com.pouyaheydari.androidappupdater.store.stores.LenovoAppCenter
import com.pouyaheydari.androidappupdater.store.stores.MiGetAppStore
import com.pouyaheydari.androidappupdater.store.stores.MyketStore
import com.pouyaheydari.androidappupdater.store.stores.NineApps
import com.pouyaheydari.androidappupdater.store.stores.OneStoreAppMarket
import com.pouyaheydari.androidappupdater.store.stores.OppoAppMarket
import com.pouyaheydari.androidappupdater.store.stores.SamsungGalaxyStore
import com.pouyaheydari.androidappupdater.store.stores.TencentAppStore
import com.pouyaheydari.androidappupdater.store.stores.VAppStore
import com.pouyaheydari.androidappupdater.store.stores.ZTEAppCenter

/**
 * Enum class to select type of market
 */
object StoreFactory {
    fun getGooglePlayStore(packageName: String) = GooglePlayStore(packageName)
    fun getAmazonAppStore(packageName: String) = AmazonAppStore(packageName)
    fun getAptoideStore(packageName: String) = Aptoide(packageName)
    fun getCafeBazaarStore(packageName: String) = CafeBazaarStore(packageName)
    fun getFdroidStore(packageName: String) = FDroid(packageName)
    fun getHuaweiAppGalleryStore(packageName: String) = HuaweiAppGallery(packageName)
    fun getLenovoAppCenterStore(packageName: String) = LenovoAppCenter(packageName)
    fun getMiStore(packageName: String) = MiGetAppStore(packageName)
    fun getMyketStore(packageName: String) = MyketStore(packageName)
    fun getNineAppsStore(packageName: String) = NineApps(packageName)
    fun getOneStore(packageName: String) = OneStoreAppMarket(packageName)
    fun getOppoAppMarketStore(packageName: String) = OppoAppMarket(packageName)
    fun getSamsungGalaxyStore(packageName: String) = SamsungGalaxyStore(packageName)
    fun getTencentAppStore(packageName: String) = TencentAppStore(packageName)
    fun getVAppStore(packageName: String) = VAppStore(packageName)
    fun getZTEStore(packageName: String) = ZTEAppCenter(packageName)
}
