package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.StoreIntentProvider

const val PLAY_URL = "market://details?id="
const val PLAY_PACKAGE = "com.android.vending"

/**
 * Opens application's page in [GooglePlay Store](https://play.google.com)
 */
object GooglePlayStore : AppStore {
    override fun getIntent(packageName: String) = StoreIntentProvider
        .Builder("$PLAY_URL$packageName")
        .withPackage(PLAY_PACKAGE)
        .build()
}
