package com.pouyaheydari.androidappupdater.utils

import android.content.Context
import com.pouyaheydari.androidappupdater.R
import com.pouyaheydari.androidappupdater.store.model.Store
import com.pouyaheydari.appupdater.dsl.store
import com.pouyaheydari.appupdater.core.R as coreR

internal fun getDSLList(context: Context) = listOf(
    store {
        store = Store.DIRECT_URL
        title = context.getString(R.string.direct_download, "1")
        url = APK_URL
        packageName = SAMPLE_PACKAGE_NAME
    },
    store {
        store = Store.DIRECT_URL
        title = context.getString(R.string.direct_download, "2")
        url = APK_URL
        packageName = SAMPLE_PACKAGE_NAME
    },
    store {
        store = Store.GOOGLE_PLAY
        title = context.getString(R.string.play)
        icon = coreR.drawable.appupdater_ic_google_play
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.CAFE_BAZAAR
        title = context.getString(R.string.bazaar)
        icon = coreR.drawable.appupdater_ic_bazar
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.MYKET
        title = context.getString(R.string.myket)
        icon = coreR.drawable.appupdater_ic_myket
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.HUAWEI_APP_GALLERY
        title = context.getString(R.string.app_gallery)
        icon = coreR.drawable.appupdater_ic_app_gallery
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.SAMSUNG_GALAXY_STORE
        title = context.getString(R.string.galaxy_store)
        icon = coreR.drawable.appupdater_ic_galaxy_store
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.AMAZON_APP_STORE
        title = context.getString(R.string.amazon_store)
        icon = coreR.drawable.appupdater_ic_amazon_app_store
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.APTOIDE
        title = context.getString(R.string.aptoide)
        icon = coreR.drawable.appupdater_ic_aptoide
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.FDROID
        title = context.getString(R.string.fdroid)
        icon = coreR.drawable.appupdater_ic_fdroid
        packageName = FDROID_SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.MI_GET_APP_STORE
        title = context.getString(R.string.mi_get_app)
        icon = coreR.drawable.appupdater_ic_get_app_store
        packageName = GET_APP_SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.ONE_STORE_APP_MARKET
        title = context.getString(R.string.one_store)
        icon = coreR.drawable.appupdater_ic_one_store
        packageName = ONE_STORE_SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.OPPO_APP_MARKET
        title = context.getString(R.string.oppo_app_market)
        icon = coreR.drawable.appupdater_ic_oppo_app_market
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.V_APP_STORE
        title = context.getString(R.string.v_app_store)
        icon = coreR.drawable.appupdater_ic_v_app_store
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.NINE_APPS_STORE
        title = context.getString(R.string.nine_apps)
        icon = coreR.drawable.appupdater_ic_nine_apps
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.TENCENT_APPS_STORE
        title = context.getString(R.string.tencent_app_store)
        icon = coreR.drawable.appupdater_ic_tencent_app_store
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.ZTE_APP_CENTER
        title = context.getString(R.string.zte_app_store)
        icon = coreR.drawable.appupdater_ic_zte_app_center
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
    store {
        store = Store.LENOVO_APP_CENTER
        title = context.getString(R.string.lenovo_app_center)
        icon = coreR.drawable.appupdater_ic_lenovo_app_center
        packageName = SAMPLE_PACKAGE_NAME
        url = WEBSITE_URL
    },
)
