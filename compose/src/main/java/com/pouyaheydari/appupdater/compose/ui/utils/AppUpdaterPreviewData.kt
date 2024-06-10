package com.pouyaheydari.appupdater.compose.ui.utils

import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.store.domain.StoreFactory
import com.pouyaheydari.appupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType
import com.pouyaheydari.appupdater.store.R as storeR

private const val CUSTOM_URL = "https://cafebazaar.ir/download/bazaar.apk"
private const val SAMPLE_PACKAGE_NAME = "com.tencent.mm"
private const val FDROID_SAMPLE_PACKAGE_NAME = "de.storchp.fdroidbuildstatus"
private const val GET_APP_SAMPLE_PACKAGE_NAME = "com.opera.browser"
private const val ONE_STORE_SAMPLE_PACKAGE_NAME = "com.kakao.talk"

internal val previewDirectDownloadListData = listOf(
    DirectDownloadListItem(
        title = "Direct Download 1",
        url = CUSTOM_URL,
    ),
    DirectDownloadListItem(
        title = "Direct Download 2",
        url = CUSTOM_URL,
    ),
)

internal val previewStoreListData = listOf(
    StoreListItem(
        StoreFactory.getStore(AppStoreType.GOOGLE_PLAY, SAMPLE_PACKAGE_NAME),
        "Google Play",
        icon = storeR.drawable.appupdater_ic_google_play,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.CAFE_BAZAAR, SAMPLE_PACKAGE_NAME),
        "Cafe Bazaar",
        icon = storeR.drawable.appupdater_ic_bazar,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.MYKET, SAMPLE_PACKAGE_NAME),
        "Myket",
        icon = storeR.drawable.appupdater_ic_myket,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.HUAWEI_APP_GALLERY, SAMPLE_PACKAGE_NAME),
        "App Gallery",
        icon = storeR.drawable.appupdater_ic_app_gallery,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.SAMSUNG_GALAXY_STORE, SAMPLE_PACKAGE_NAME),
        "Galaxy Store",
        icon = storeR.drawable.appupdater_ic_galaxy_store,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.AMAZON_APP_STORE, SAMPLE_PACKAGE_NAME),
        "Amazon App Store",
        icon = storeR.drawable.appupdater_ic_amazon_app_store,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.APTOIDE, SAMPLE_PACKAGE_NAME),
        "Aptoide",
        icon = storeR.drawable.appupdater_ic_aptoide,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.OPPO_APP_MARKET, SAMPLE_PACKAGE_NAME),
        "Oppo App Market",
        icon = storeR.drawable.appupdater_ic_oppo_app_market,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.V_APP_STORE, SAMPLE_PACKAGE_NAME),
        "V-APP Store",
        icon = storeR.drawable.appupdater_ic_v_app_store,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.NINE_APPS_STORE, SAMPLE_PACKAGE_NAME),
        "Nine Apps",
        icon = storeR.drawable.appupdater_ic_nine_apps,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.TENCENT_APPS_STORE, SAMPLE_PACKAGE_NAME),
        "Tencent AppStore",
        icon = storeR.drawable.appupdater_ic_tencent_app_store,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.ZTE_APP_CENTER, SAMPLE_PACKAGE_NAME),
        "ZTE App Store",
        icon = storeR.drawable.appupdater_ic_zte_app_center,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.LENOVO_APP_CENTER, SAMPLE_PACKAGE_NAME),
        "Lenovo App Center",
        icon = storeR.drawable.appupdater_ic_zte_app_center,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.FDROID, FDROID_SAMPLE_PACKAGE_NAME),
        "FDroid",
        icon = storeR.drawable.appupdater_ic_fdroid,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.MI_GET_APP_STORE, GET_APP_SAMPLE_PACKAGE_NAME),
        "Mi GetApp",
        icon = storeR.drawable.appupdater_ic_get_app_store,
    ),
    StoreListItem(
        StoreFactory.getStore(AppStoreType.ONE_STORE_APP_MARKET, ONE_STORE_SAMPLE_PACKAGE_NAME),
        "One Store",
        icon = storeR.drawable.appupdater_ic_one_store,
    ),
)
