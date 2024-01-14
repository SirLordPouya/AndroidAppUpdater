package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.AndroidIntentBuilder

const val FDROID_URL = "fdroid.app://details?id="
const val FDROID_PACKAGE = "org.fdroid.fdroid"

/**
 * Opens application's page in [F-Droid App Store](https://f-droid.org/)
 */
object FDroid : AppStore {
    override fun getIntent(packageName: String) = AndroidIntentBuilder
        .addUriString("$FDROID_URL$packageName")
        .addPackage(FDROID_PACKAGE)
        .build()
}
