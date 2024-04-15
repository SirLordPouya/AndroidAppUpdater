package com.pouyaheydari.appupdater.compose.ui.utils

import com.pouyaheydari.androidappupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.androidappupdater.store.domain.StoreFactory
import com.pouyaheydari.androidappupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.core.R as coreR

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
        StoreFactory.getGooglePlayStore(SAMPLE_PACKAGE_NAME),
        "Google Play",
        icon = coreR.drawable.appupdater_ic_google_play,
    ),
    StoreListItem(
        StoreFactory.getCafeBazaarStore(SAMPLE_PACKAGE_NAME),
        "Cafe Bazaar",
        icon = coreR.drawable.appupdater_ic_bazar,
    ),
    StoreListItem(
        StoreFactory.getMyketStore(SAMPLE_PACKAGE_NAME),
        "Myket",
        icon = coreR.drawable.appupdater_ic_myket,
    ),
    StoreListItem(
        StoreFactory.getHuaweiAppGalleryStore(SAMPLE_PACKAGE_NAME),
        "App Gallery",
        icon = coreR.drawable.appupdater_ic_app_gallery,
    ),
    StoreListItem(
        StoreFactory.getSamsungGalaxyStore(SAMPLE_PACKAGE_NAME),
        "Galaxy Store",
        icon = coreR.drawable.appupdater_ic_galaxy_store,
    ),
    StoreListItem(
        StoreFactory.getAmazonAppStore(SAMPLE_PACKAGE_NAME),
        "Amazon App Store",
        icon = coreR.drawable.appupdater_ic_amazon_app_store,
    ),
    StoreListItem(
        StoreFactory.getAptoideStore(SAMPLE_PACKAGE_NAME),
        "Aptoide",
        icon = coreR.drawable.appupdater_ic_aptoide,
    ),
    StoreListItem(
        StoreFactory.getOppoAppMarketStore(SAMPLE_PACKAGE_NAME),
        "Oppo App Market",
        icon = coreR.drawable.appupdater_ic_oppo_app_market,
    ),
    StoreListItem(
        StoreFactory.getVAppStore(SAMPLE_PACKAGE_NAME),
        "V-APP Store",
        icon = coreR.drawable.appupdater_ic_v_app_store,
    ),
    StoreListItem(
        StoreFactory.getNineAppsStore(SAMPLE_PACKAGE_NAME),
        "Nine Apps",
        icon = coreR.drawable.appupdater_ic_nine_apps,
    ),
    StoreListItem(
        StoreFactory.getTencentAppStore(SAMPLE_PACKAGE_NAME),
        "Tencent AppStore",
        icon = coreR.drawable.appupdater_ic_tencent_app_store,
    ),
    StoreListItem(
        StoreFactory.getZTEStore(SAMPLE_PACKAGE_NAME),
        "ZTE App Store",
        icon = coreR.drawable.appupdater_ic_zte_app_center,
    ),
    StoreListItem(
        StoreFactory.getLenovoAppCenterStore(SAMPLE_PACKAGE_NAME),
        "Lenovo App Center",
        icon = coreR.drawable.appupdater_ic_zte_app_center,
    ),
    StoreListItem(
        StoreFactory.getFdroidStore(FDROID_SAMPLE_PACKAGE_NAME),
        "FDroid",
        icon = coreR.drawable.appupdater_ic_fdroid,
    ),
    StoreListItem(
        StoreFactory.getMiStore(GET_APP_SAMPLE_PACKAGE_NAME),
        "Mi GetApp",
        icon = coreR.drawable.appupdater_ic_get_app_store,
    ),
    StoreListItem(
        StoreFactory.getOneStore(ONE_STORE_SAMPLE_PACKAGE_NAME),
        "One Store",
        icon = coreR.drawable.appupdater_ic_one_store,
    ),
)
