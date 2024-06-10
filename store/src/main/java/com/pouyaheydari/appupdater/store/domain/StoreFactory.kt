package com.pouyaheydari.appupdater.store.domain

import com.pouyaheydari.appupdater.store.domain.stores.AmazonAppStore
import com.pouyaheydari.appupdater.store.domain.stores.AppStore
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.AMAZON_APP_STORE
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.APTOIDE
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.CAFE_BAZAAR
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.FDROID
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.GOOGLE_PLAY
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.HUAWEI_APP_GALLERY
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.LENOVO_APP_CENTER
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.MI_GET_APP_STORE
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.MYKET
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.NINE_APPS_STORE
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.ONE_STORE_APP_MARKET
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.OPPO_APP_MARKET
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.SAMSUNG_GALAXY_STORE
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.TENCENT_APPS_STORE
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.V_APP_STORE
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType.ZTE_APP_CENTER
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

object StoreFactory {
    fun getStore(storeType: AppStoreType, packageName: String): AppStore = when (storeType) {
        GOOGLE_PLAY -> GooglePlayStore(packageName)
        CAFE_BAZAAR -> CafeBazaarStore(packageName)
        MYKET -> MyketStore(packageName)
        HUAWEI_APP_GALLERY -> HuaweiAppGallery(packageName)
        SAMSUNG_GALAXY_STORE -> SamsungGalaxyStore(packageName)
        AMAZON_APP_STORE -> AmazonAppStore(packageName)
        APTOIDE -> Aptoide(packageName)
        FDROID -> FDroid(packageName)
        MI_GET_APP_STORE -> MiGetAppStore(packageName)
        ONE_STORE_APP_MARKET -> OneStoreAppMarket(packageName)
        OPPO_APP_MARKET -> OppoAppMarket(packageName)
        V_APP_STORE -> VAppStore(packageName)
        NINE_APPS_STORE -> NineApps(packageName)
        TENCENT_APPS_STORE -> TencentAppStore(packageName)
        ZTE_APP_CENTER -> ZTEAppCenter(packageName)
        LENOVO_APP_CENTER -> LenovoAppCenter(packageName)
    }
}
