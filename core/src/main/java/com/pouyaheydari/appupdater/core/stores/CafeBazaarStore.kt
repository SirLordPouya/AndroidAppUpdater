package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.AndroidIntentBuilder

const val BAZAAR_URL = "bazaar://details?id="
const val BAZAAR_PACKAGE = "com.farsitel.bazaar"

/**
 * Opens application's page in [CafeBazaar App Store](https://cafebazaar.ir)
 */
object CafeBazaarStore : AppStore {
    override fun getIntent(packageName: String) = AndroidIntentBuilder
        .addUriString("$BAZAAR_URL$packageName")
        .addPackage(BAZAAR_PACKAGE)
        .build()
}
