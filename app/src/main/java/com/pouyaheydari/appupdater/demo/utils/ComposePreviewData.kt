package com.pouyaheydari.appupdater.demo.utils

import android.content.Context
import com.pouyaheydari.appupdater.demo.R
import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.store.domain.StoreFactory
import com.pouyaheydari.appupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.store.R as storeR

internal fun directDownloadList(context: Context) = listOf(
    DirectDownloadListItem(
        title = context.getString(R.string.direct_download, "1"),
        url = APK_URL,
    ),
    DirectDownloadListItem(
        title = context.getString(R.string.direct_download, "2"),
        url = APK_URL,
    ),
)

internal fun storeList(context: Context) = listOf(
    StoreListItem(
        StoreFactory.getGooglePlayStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.play),
        icon = storeR.drawable.appupdater_ic_google_play,
    ),
    StoreListItem(
        StoreFactory.getCafeBazaarStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.bazaar),
        icon = storeR.drawable.appupdater_ic_bazar,
    ),
    StoreListItem(
        StoreFactory.getMyketStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.myket),
        icon = storeR.drawable.appupdater_ic_myket,
    ),
    StoreListItem(
        StoreFactory.getHuaweiAppGalleryStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.app_gallery),
        icon = storeR.drawable.appupdater_ic_app_gallery,
    ),
    StoreListItem(
        StoreFactory.getSamsungGalaxyStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.galaxy_store),
        icon = storeR.drawable.appupdater_ic_galaxy_store,
    ),
    StoreListItem(
        StoreFactory.getAmazonAppStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.amazon_store),
        icon = storeR.drawable.appupdater_ic_amazon_app_store,
    ),
    StoreListItem(
        StoreFactory.getAptoideStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.aptoide),
        icon = storeR.drawable.appupdater_ic_aptoide,
    ),
    StoreListItem(
        StoreFactory.getOppoAppMarketStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.oppo_app_market),
        icon = storeR.drawable.appupdater_ic_oppo_app_market,
    ),
    StoreListItem(
        StoreFactory.getVAppStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.v_app_store),
        icon = storeR.drawable.appupdater_ic_v_app_store,
    ),
    StoreListItem(
        StoreFactory.getNineAppsStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.nine_apps),
        icon = storeR.drawable.appupdater_ic_nine_apps,
    ),
    StoreListItem(
        StoreFactory.getTencentAppStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.tencent_app_store),
        icon = storeR.drawable.appupdater_ic_tencent_app_store,
    ),
    StoreListItem(
        StoreFactory.getZTEStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.zte_app_store),
        icon = storeR.drawable.appupdater_ic_zte_app_center,
    ),
    StoreListItem(
        StoreFactory.getLenovoAppCenterStore(SAMPLE_PACKAGE_NAME),
        context.getString(R.string.lenovo_app_center),
        icon = storeR.drawable.appupdater_ic_lenovo_app_center,
    ),
    StoreListItem(
        StoreFactory.getFdroidStore(FDROID_SAMPLE_PACKAGE_NAME),
        context.getString(R.string.fdroid),
        icon = storeR.drawable.appupdater_ic_fdroid,
    ),
    StoreListItem(
        StoreFactory.getMiStore(GET_APP_SAMPLE_PACKAGE_NAME),
        context.getString(R.string.mi_get_app),
        icon = storeR.drawable.appupdater_ic_get_app_store,
    ),
    StoreListItem(
        StoreFactory.getOneStore(ONE_STORE_SAMPLE_PACKAGE_NAME),
        context.getString(R.string.one_store),
        icon = storeR.drawable.appupdater_ic_one_store,
    ),
)
