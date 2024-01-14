package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.AndroidIntentBuilder

const val SAMSUNG_GALAXY_STORE_URL = "samsungapps://ProductDetail/"

/**
 * Opens application's page in [Samsung Galaxy store](https://www.samsung.com/de/apps/galaxy-store/)
 */
object SamsungGalaxyStore : AppStore {
    override fun getIntent(packageName: String) = AndroidIntentBuilder
        .addUriString("$SAMSUNG_GALAXY_STORE_URL$packageName")
        .build()
}
