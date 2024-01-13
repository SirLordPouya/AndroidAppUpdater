package com.pouyaheydari.androidappupdater.utils

import android.content.Context
import com.pouyaheydari.androidappupdater.R
import com.pouyaheydari.appupdater.core.data.model.Store
import com.pouyaheydari.appupdater.core.data.model.StoreListItem
import com.pouyaheydari.appupdater.core.R as coreR

/**
 * @return A list of [com.pouyaheydari.appupdater.core.data.model.StoreListItem] to be used in the compose and fragment sample codes
 */
internal fun getNormalList(context: Context) = listOf(
    // direct download
    StoreListItem(
        store = Store.DIRECT_URL,
        title = context.getString(R.string.direct_download, "1"),
        url = APK_URL,
        packageName = SAMPLE_PACKAGE_NAME,
    ),
    StoreListItem(
        store = Store.DIRECT_URL,
        title = context.getString(R.string.direct_download, "2"),
        url = APK_URL,
        packageName = SAMPLE_PACKAGE_NAME,
    ),
    // stores
    StoreListItem(
        store = Store.GOOGLE_PLAY,
        title = context.getString(R.string.play),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_google_play,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.CAFE_BAZAAR,
        title = context.getString(R.string.bazaar),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_bazar,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.MYKET,
        title = context.getString(R.string.myket),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_myket,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.HUAWEI_APP_GALLERY,
        title = context.getString(R.string.app_gallery),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_app_gallery,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.SAMSUNG_GALAXY_STORE,
        title = context.getString(R.string.galaxy_store),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_galaxy_store,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.AMAZON_APP_STORE,
        title = context.getString(R.string.amazon_store),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_amazon_app_store,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.APTOIDE,
        title = context.getString(R.string.aptoide),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_aptoide,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.FDROID,
        title = context.getString(R.string.fdroid),
        packageName = FDROID_SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_fdroid,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.MI_GET_APP_STORE,
        title = context.getString(R.string.mi_get_app),
        packageName = GET_APP_SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_get_app_store,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.ONE_STORE_APP_MARKET,
        title = context.getString(R.string.one_store),
        packageName = ONE_STORE_SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_one_store,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.OPPO_APP_MARKET,
        title = context.getString(R.string.oppo_app_market),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_oppo_app_market,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.V_APP_STORE,
        title = context.getString(R.string.v_app_store),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_v_app_store,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.NINE_APPS_STORE,
        title = context.getString(R.string.nine_apps),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_nine_apps,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.TENCENT_APPS_STORE,
        title = context.getString(R.string.tencent_app_store),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_tencent_app_store,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.ZTE_APP_CENTER,
        title = context.getString(R.string.zte_app_store),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_zte_app_center,
        url = WEBSITE_URL,
    ),
    StoreListItem(
        store = Store.LENOVO_APP_CENTER,
        title = context.getString(R.string.lenovo_app_center),
        packageName = SAMPLE_PACKAGE_NAME,
        icon = coreR.drawable.appupdater_ic_lenovo_app_center,
        url = WEBSITE_URL,
    ),
)
