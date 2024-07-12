package com.pouyaheydari.appupdater.demo.utils

import android.content.Context
import com.pouyaheydari.appupdater.demo.R
import com.pouyaheydari.appupdater.main.dsl.directDownload
import com.pouyaheydari.appupdater.main.dsl.store
import com.pouyaheydari.appupdater.store.domain.StoreFactory
import com.pouyaheydari.appupdater.store.domain.stores.AppStoreType
import com.pouyaheydari.appupdater.store.R as storeR

internal fun getDslDirectDownloadLink(context: Context) = listOf(
    directDownload {
        title = context.getString(R.string.direct_download, "1")
        url = APK_URL
    },
    directDownload {
        title = context.getString(R.string.direct_download, "2")
        url = APK_URL
    },
)

internal fun getDSLStoreList(context: Context) = listOf(
    store {
        store = StoreFactory.getStore(AppStoreType.GOOGLE_PLAY, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.play)
        icon = storeR.drawable.appupdater_ic_google_play
    },
    store {
        store = StoreFactory.getStore(AppStoreType.CAFE_BAZAAR, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.bazaar)
        icon = storeR.drawable.appupdater_ic_bazar
    },
    store {
        store = StoreFactory.getStore(AppStoreType.MYKET, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.myket)
        icon = storeR.drawable.appupdater_ic_myket
    },
    store {
        store = StoreFactory.getStore(AppStoreType.HUAWEI_APP_GALLERY, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.app_gallery)
        icon = storeR.drawable.appupdater_ic_app_gallery
    },
    store {
        store = StoreFactory.getStore(AppStoreType.SAMSUNG_GALAXY_STORE, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.galaxy_store)
        icon = storeR.drawable.appupdater_ic_galaxy_store
    },
    store {
        store = StoreFactory.getStore(AppStoreType.AMAZON_APP_STORE, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.amazon_store)
        icon = storeR.drawable.appupdater_ic_amazon_app_store
    },
    store {
        store = StoreFactory.getStore(AppStoreType.APTOIDE, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.aptoide)
        icon = storeR.drawable.appupdater_ic_aptoide
    },
    store {
        store = StoreFactory.getStore(AppStoreType.OPPO_APP_MARKET, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.oppo_app_market)
        icon = storeR.drawable.appupdater_ic_oppo_app_market
    },
    store {
        store = StoreFactory.getStore(AppStoreType.V_APP_STORE, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.v_app_store)
        icon = storeR.drawable.appupdater_ic_v_app_store
    },
    store {
        store = StoreFactory.getStore(AppStoreType.NINE_APPS_STORE, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.nine_apps)
        icon = storeR.drawable.appupdater_ic_nine_apps
    },
    store {
        store = StoreFactory.getStore(AppStoreType.TENCENT_APPS_STORE, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.tencent_app_store)
        icon = storeR.drawable.appupdater_ic_tencent_app_store
    },
    store {
        store = StoreFactory.getStore(AppStoreType.ZTE_APP_CENTER, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.zte_app_store)
        icon = storeR.drawable.appupdater_ic_zte_app_center
    },
    store {
        store = StoreFactory.getStore(AppStoreType.LENOVO_APP_CENTER, SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.lenovo_app_center)
        icon = storeR.drawable.appupdater_ic_lenovo_app_center
    },
    store {
        store = StoreFactory.getStore(AppStoreType.FDROID, FDROID_SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.fdroid)
        icon = storeR.drawable.appupdater_ic_fdroid
    },
    store {
        store = StoreFactory.getStore(AppStoreType.MI_GET_APP_STORE, GET_APP_SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.mi_get_app)
        icon = storeR.drawable.appupdater_ic_get_app_store
    },
    store {
        store = StoreFactory.getStore(AppStoreType.ONE_STORE_APP_MARKET, ONE_STORE_SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.one_store)
        icon = storeR.drawable.appupdater_ic_one_store
    },
)