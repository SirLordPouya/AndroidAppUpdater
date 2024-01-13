package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val PLAY_URL = "market://details?id="
const val PLAY_PACKAGE = "com.android.vending"

/**
 * Opens application's page in [GooglePlay Store](https://play.google.com)
 */
object GooglePlayStore : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$PLAY_URL$packageName")).run {
            setPackage(PLAY_PACKAGE)
        }
}
