package com.pouyaheydari.androidappupdater.utils

import android.content.Context
import com.pouyaheydari.androidappupdater.R
import com.pouyaheydari.appupdater.core.pojo.Store
import com.pouyaheydari.appupdater.core.pojo.UpdaterStoreList

fun getNormalList(context: Context) = listOf(
    // direct download
    UpdaterStoreList(
        store = Store.DIRECT_URL,
        title = context.getString(R.string.direct_download, "1"),
        icon = R.mipmap.ic_launcher,
        url = APK_URL,
        packageName = SAMPLE_PACKAGE_NAME,
    ),
    UpdaterStoreList(
        store = Store.DIRECT_URL,
        title = context.getString(R.string.direct_download, "2"),
        icon = R.mipmap.ic_launcher,
        url = APK_URL,
        packageName = SAMPLE_PACKAGE_NAME,
    ),
    // stores
    UpdaterStoreList(
        store = Store.GOOGLE_PLAY,
        title = context.getString(R.string.play),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = R.drawable.appupdater_ic_google_play,
        url = WEBSITE_URL,
    ),
    UpdaterStoreList(
        store = Store.CAFE_BAZAAR,
        title = context.getString(R.string.bazaar),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = R.drawable.appupdater_ic_bazar,
        url = WEBSITE_URL,
    ),
    UpdaterStoreList(
        store = Store.MYKET,
        title = context.getString(R.string.myket),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = R.drawable.appupdater_ic_myket,
        url = WEBSITE_URL,
    ),
    UpdaterStoreList(
        store = Store.HUAWEI_APP_GALLERY,
        title = context.getString(R.string.app_gallery),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = R.drawable.appupdater_ic_app_gallery,
        url = WEBSITE_URL,
    ),
    UpdaterStoreList(
        store = Store.SAMSUNG_GALAXY_STORE,
        title = context.getString(R.string.galaxy_store),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = R.drawable.appupdater_ic_galaxy_store,
        url = WEBSITE_URL,
    ),
    UpdaterStoreList(
        store = Store.AMAZON_APP_STORE,
        title = context.getString(R.string.amazon_store),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = R.drawable.appupdater_ic_amazon_app_store,
        url = WEBSITE_URL,
    ),
    UpdaterStoreList(
        store = Store.APTOIDE,
        title = context.getString(R.string.aptoide),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = R.drawable.appupdater_ic_aptoide,
        url = WEBSITE_URL,
    ),
    UpdaterStoreList(
        store = Store.FDROID,
        title = context.getString(R.string.fdroid),
        packageName = FDROID_SAMPLE_PACKAGE_NAME,
        icon = R.drawable.appupdater_ic_fdroid,
        url = WEBSITE_URL,
    ),
    UpdaterStoreList(
        store = Store.MI_GET_APP_STORE,
        title = context.getString(R.string.mi_get_app),
        packageName = GET_APP_SAMPLE_PACKAGE_NAME,
        icon = R.drawable.appupdater_ic_get_app_store,
        url = WEBSITE_URL,
    ),
    UpdaterStoreList(
        store = Store.ONE_STORE_APP_MARKET,
        title = context.getString(R.string.one_store),
        packageName = ONE_STORE_SAMPLE_PACKAGE_NAME,
        icon = R.drawable.appupdater_ic_one_store,
        url = WEBSITE_URL,
    ),
    UpdaterStoreList(
        store = Store.OPPO_APP_MARKET,
        title = context.getString(R.string.oppo_app_market),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = R.drawable.appupdater_ic_oppo_app_market,
        url = WEBSITE_URL,
    ),
    UpdaterStoreList(
        store = Store.V_APP_STORE,
        title = context.getString(R.string.v_app_store),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = R.drawable.appupdater_ic_v_app_store,
        url = WEBSITE_URL,
    ),
)
