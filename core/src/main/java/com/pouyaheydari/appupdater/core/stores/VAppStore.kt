package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val V_APP_STORE_URL = "vivoMarket://details?id="

/**
 * Opens application's page in [V-AppStore](https://developer.vivo.com/home)
 */
object VAppStore : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$V_APP_STORE_URL$packageName"))
}
