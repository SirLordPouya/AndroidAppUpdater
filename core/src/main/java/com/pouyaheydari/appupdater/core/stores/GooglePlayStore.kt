package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.AndroidIntentBuilder

const val PLAY_URL = "market://details?id="
const val PLAY_PACKAGE = "com.android.vending"

/**
 * Opens application's page in [GooglePlay Store](https://play.google.com)
 */
object GooglePlayStore : AppStore {
    override fun getIntent(packageName: String) = AndroidIntentBuilder
        .addUriString("$PLAY_URL$packageName")
        .addPackage(PLAY_PACKAGE)
        .build()
}
