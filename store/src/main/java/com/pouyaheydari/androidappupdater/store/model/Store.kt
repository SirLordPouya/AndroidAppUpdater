package com.pouyaheydari.androidappupdater.store.model

import com.pouyaheydari.androidappupdater.store.stores.AmazonAppStore
import com.pouyaheydari.androidappupdater.store.stores.AppStore
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
enum class Store(val provider: Class<out AppStore>?) {
    DIRECT_URL(null),
    GOOGLE_PLAY(GooglePlayStore::class.java),
    CAFE_BAZAAR(CafeBazaarStore::class.java),
    MYKET(MyketStore::class.java),
    HUAWEI_APP_GALLERY(HuaweiAppGallery::class.java),
    SAMSUNG_GALAXY_STORE(SamsungGalaxyStore::class.java),
    AMAZON_APP_STORE(AmazonAppStore::class.java),
    APTOIDE(Aptoide::class.java),
    FDROID(FDroid::class.java),
    MI_GET_APP_STORE(MiGetAppStore::class.java),
    ONE_STORE_APP_MARKET(OneStoreAppMarket::class.java),
    OPPO_APP_MARKET(OppoAppMarket::class.java),
    V_APP_STORE(VAppStore::class.java),
    NINE_APPS_STORE(NineApps::class.java),
    TENCENT_APPS_STORE(TencentAppStore::class.java),
    ZTE_APP_CENTER(ZTEAppCenter::class.java),
    LENOVO_APP_CENTER(LenovoAppCenter::class.java),
}
