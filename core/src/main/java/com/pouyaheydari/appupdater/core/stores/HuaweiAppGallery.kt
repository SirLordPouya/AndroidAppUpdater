package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val HUAWEI_APP_GALLERY_URL = "appmarket://details?id="
const val HUAWEI_APP_GALLERY_PACKAGE = "com.huawei.appmarket"

/**
 * Opens application's page in [Huawei App Gallery](https://appgallery.huawei.com/)
 */
object HuaweiAppGallery : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$HUAWEI_APP_GALLERY_URL$packageName")).run {
            setPackage(HUAWEI_APP_GALLERY_PACKAGE)
        }
}
