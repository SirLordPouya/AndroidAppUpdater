package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val TENCENT_APP_STORE_URL = "tmast://appdetails?pname="

/**
 * Opens application's page in [Tencent App Store](https://appstore.tencent.com/)
 */
object TencentAppStore : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$TENCENT_APP_STORE_URL$packageName"))
}
