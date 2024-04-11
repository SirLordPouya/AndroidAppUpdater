package com.pouyaheydari.androidappupdater.store.domain

import com.pouyaheydari.androidappupdater.store.domain.stores.AmazonAppStore
import com.pouyaheydari.androidappupdater.store.domain.stores.Aptoide
import com.pouyaheydari.androidappupdater.store.domain.stores.CafeBazaarStore
import com.pouyaheydari.androidappupdater.store.domain.stores.FDroid
import com.pouyaheydari.androidappupdater.store.domain.stores.GooglePlayStore
import com.pouyaheydari.androidappupdater.store.domain.stores.HuaweiAppGallery
import com.pouyaheydari.androidappupdater.store.domain.stores.LenovoAppCenter
import com.pouyaheydari.androidappupdater.store.domain.stores.MiGetAppStore
import com.pouyaheydari.androidappupdater.store.domain.stores.MyketStore
import com.pouyaheydari.androidappupdater.store.domain.stores.NineApps
import com.pouyaheydari.androidappupdater.store.domain.stores.OneStoreAppMarket
import com.pouyaheydari.androidappupdater.store.domain.stores.OppoAppMarket
import com.pouyaheydari.androidappupdater.store.domain.stores.SamsungGalaxyStore
import com.pouyaheydari.androidappupdater.store.domain.stores.TencentAppStore
import com.pouyaheydari.androidappupdater.store.domain.stores.VAppStore
import com.pouyaheydari.androidappupdater.store.domain.stores.ZTEAppCenter

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
