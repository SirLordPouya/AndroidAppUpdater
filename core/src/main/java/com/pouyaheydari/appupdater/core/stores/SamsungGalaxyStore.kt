package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val SAMSUNG_GALAXY_STORE_URL = "samsungapps://ProductDetail/"

/**
 * Opens application's page in [Samsung Galaxy store](https://www.samsung.com/de/apps/galaxy-store/)
 */
object SamsungGalaxyStore : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$SAMSUNG_GALAXY_STORE_URL$packageName"))
}
