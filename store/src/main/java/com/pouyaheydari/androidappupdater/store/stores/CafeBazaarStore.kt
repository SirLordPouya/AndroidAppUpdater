package com.pouyaheydari.androidappupdater.store.stores

import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

const val BAZAAR_URL = "bazaar://details?id="
const val BAZAAR_PACKAGE = "com.farsitel.bazaar"

/**
 * Opens application's page in [CafeBazaar App Store](https://cafebazaar.ir)
 */
object CafeBazaarStore : AppStore {
    override fun getIntent(packageName: String) = StoreIntentProvider
        .Builder("$BAZAAR_URL$packageName")
        .withPackage(BAZAAR_PACKAGE)
        .build()
}
