package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val MI_APP_STORE_URL = "mimarket://details?id="

/**
 * Opens application's page in [Xiaomi GetApp store](https://global.app.mi.com/)
 */
object MiGetAppStore : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$MI_APP_STORE_URL$packageName"))
}
