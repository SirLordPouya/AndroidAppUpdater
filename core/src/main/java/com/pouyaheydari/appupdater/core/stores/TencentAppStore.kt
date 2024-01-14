package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.AndroidIntentBuilder

const val TENCENT_APP_STORE_URL = "tmast://appdetails?pname="

/**
 * Opens application's page in [Tencent App Store](https://appstore.tencent.com/)
 */
object TencentAppStore : AppStore {
    override fun getIntent(packageName: String) = AndroidIntentBuilder
        .addUriString("$TENCENT_APP_STORE_URL$packageName")
        .build()
}
