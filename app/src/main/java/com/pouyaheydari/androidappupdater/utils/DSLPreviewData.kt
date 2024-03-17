package com.pouyaheydari.androidappupdater.utils

import android.content.Context
import com.pouyaheydari.androidappupdater.R
import com.pouyaheydari.androidappupdater.store.domain.StoreFactory
import com.pouyaheydari.appupdater.dsl.directDownload
import com.pouyaheydari.appupdater.dsl.store
import com.pouyaheydari.appupdater.core.R as coreR

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
        store = StoreFactory.getGooglePlayStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.play)
        icon = coreR.drawable.appupdater_ic_google_play
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getCafeBazaarStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.bazaar)
        icon = coreR.drawable.appupdater_ic_bazar
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getMyketStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.myket)
        icon = coreR.drawable.appupdater_ic_myket
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getHuaweiAppGalleryStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.app_gallery)
        icon = coreR.drawable.appupdater_ic_app_gallery
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getSamsungGalaxyStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.galaxy_store)
        icon = coreR.drawable.appupdater_ic_galaxy_store
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getAmazonAppStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.amazon_store)
        icon = coreR.drawable.appupdater_ic_amazon_app_store
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getAptoideStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.aptoide)
        icon = coreR.drawable.appupdater_ic_aptoide
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getOppoAppMarketStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.oppo_app_market)
        icon = coreR.drawable.appupdater_ic_oppo_app_market
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getVAppStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.v_app_store)
        icon = coreR.drawable.appupdater_ic_v_app_store
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getNineAppsStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.nine_apps)
        icon = coreR.drawable.appupdater_ic_nine_apps
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getTencentAppStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.tencent_app_store)
        icon = coreR.drawable.appupdater_ic_tencent_app_store
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getZTEStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.zte_app_store)
        icon = coreR.drawable.appupdater_ic_zte_app_center
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getLenovoAppCenterStore(SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.lenovo_app_center)
        icon = coreR.drawable.appupdater_ic_lenovo_app_center
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getFdroidStore(FDROID_SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.fdroid)
        icon = coreR.drawable.appupdater_ic_fdroid
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getMiStore(GET_APP_SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.mi_get_app)
        icon = coreR.drawable.appupdater_ic_get_app_store
        url = WEBSITE_URL
    },
    store {
        store = StoreFactory.getOneStore(ONE_STORE_SAMPLE_PACKAGE_NAME)
        title = context.getString(R.string.one_store)
        icon = coreR.drawable.appupdater_ic_one_store
        url = WEBSITE_URL
    },
)
