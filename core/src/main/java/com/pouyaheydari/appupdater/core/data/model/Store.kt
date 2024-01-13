package com.pouyaheydari.appupdater.core.data.model

import com.pouyaheydari.appupdater.core.stores.AmazonAppStore
import com.pouyaheydari.appupdater.core.stores.AppStore
import com.pouyaheydari.appupdater.core.stores.Aptoide
import com.pouyaheydari.appupdater.core.stores.CafeBazaarStore
import com.pouyaheydari.appupdater.core.stores.FDroid
import com.pouyaheydari.appupdater.core.stores.GooglePlayStore
import com.pouyaheydari.appupdater.core.stores.HuaweiAppGallery
import com.pouyaheydari.appupdater.core.stores.LenovoAppCenter
import com.pouyaheydari.appupdater.core.stores.MiGetAppStore
import com.pouyaheydari.appupdater.core.stores.MyketStore
import com.pouyaheydari.appupdater.core.stores.NineApps
import com.pouyaheydari.appupdater.core.stores.OneStoreAppMarket
import com.pouyaheydari.appupdater.core.stores.OppoAppMarket
import com.pouyaheydari.appupdater.core.stores.SamsungGalaxyStore
import com.pouyaheydari.appupdater.core.stores.TencentAppStore
import com.pouyaheydari.appupdater.core.stores.VAppStore
import com.pouyaheydari.appupdater.core.stores.ZTEAppCenter

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
