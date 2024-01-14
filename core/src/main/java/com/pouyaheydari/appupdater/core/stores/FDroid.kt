package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.StoreIntentProvider

const val FDROID_URL = "fdroid.app://details?id="
const val FDROID_PACKAGE = "org.fdroid.fdroid"

/**
 * Opens application's page in [F-Droid App Store](https://f-droid.org/)
 */
object FDroid : AppStore {
    override fun getIntent(packageName: String) = StoreIntentProvider
        .Builder("$FDROID_URL$packageName")
        .withPackage(FDROID_PACKAGE)
        .build()
}
