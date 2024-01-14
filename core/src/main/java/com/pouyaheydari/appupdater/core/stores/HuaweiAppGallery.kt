package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.AndroidIntentBuilder

const val HUAWEI_APP_GALLERY_URL = "appmarket://details?id="
const val HUAWEI_APP_GALLERY_PACKAGE = "com.huawei.appmarket"

/**
 * Opens application's page in [Huawei App Gallery](https://appgallery.huawei.com/)
 */
object HuaweiAppGallery : AppStore {
    override fun getIntent(packageName: String) = AndroidIntentBuilder
        .addUriString("$HUAWEI_APP_GALLERY_URL$packageName")
        .addPackage(HUAWEI_APP_GALLERY_PACKAGE)
        .build()
}
