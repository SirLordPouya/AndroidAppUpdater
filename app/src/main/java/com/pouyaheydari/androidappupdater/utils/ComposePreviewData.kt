package com.pouyaheydari.androidappupdater.utils

import com.pouyaheydari.appupdater.core.data.model.Store
import com.pouyaheydari.appupdater.core.data.model.StoreListItem
import com.pouyaheydari.appupdater.core.R as coreR

internal val directDownloadList = listOf(
    StoreListItem(
        store = Store.DIRECT_URL,
        title = "Direct Download 1",
        icon = coreR.drawable.appupdater_ic_cloud,
        url = APK_URL,
        packageName = SAMPLE_PACKAGE_NAME,
    ),
    StoreListItem(
        store = Store.DIRECT_URL,
        title = "Direct Download 2",
        icon = coreR.drawable.appupdater_ic_cloud,
        url = APK_URL,
        packageName = SAMPLE_PACKAGE_NAME,
    ),
)

internal val storeList = listOf(
    StoreListItem(
        Store.GOOGLE_PLAY,
        "Google Play",
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_google_play,
    ),
    StoreListItem(
        Store.CAFE_BAZAAR,
        "Cafe Bazaar",
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_bazar,
    ),
    StoreListItem(
        Store.MYKET,
        "Myket",
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_myket,
    ),
    StoreListItem(
        Store.HUAWEI_APP_GALLERY,
        "App Gallery",
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_app_gallery,
    ),
    StoreListItem(
        Store.SAMSUNG_GALAXY_STORE,
        "Galaxy Store",
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_galaxy_store,
    ),
    StoreListItem(
        Store.AMAZON_APP_STORE,
        "Amazon App Store",
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_amazon_app_store,
    ),
    StoreListItem(
        Store.APTOIDE,
        "Aptoide",
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_aptoide,
    ),
    StoreListItem(
        Store.FDROID,
        "FDroid",
        packageName = FDROID_SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_fdroid,
    ),
    StoreListItem(
        Store.MI_GET_APP_STORE,
        "Mi GetApp",
        packageName = GET_APP_SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_get_app_store,
    ),
    StoreListItem(
        Store.ONE_STORE_APP_MARKET,
        "One Store",
        packageName = ONE_STORE_SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_one_store,
    ),
    StoreListItem(
        Store.OPPO_APP_MARKET,
        "Oppo App Market",
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_oppo_app_market,
    ),
)
