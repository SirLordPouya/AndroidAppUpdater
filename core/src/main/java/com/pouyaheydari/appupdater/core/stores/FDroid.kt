package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val FDROID_URL = "fdroid.app://details?id="
const val FDROID_PACKAGE = "org.fdroid.fdroid"

/**
 * Opens application's page in [F-Droid App Store](https://f-droid.org/)
 */
object FDroid : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$FDROID_URL$packageName")).run {
            setPackage(FDROID_PACKAGE)
        }
}
