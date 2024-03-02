package com.pouyaheydari.androidappupdater.store.stores

import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

const val AMAZON_APP_STORE_URL = "amzn://apps/android?p="
const val AMAZON_PACKAGE = "com.amazon.venezia"

/**
 * Opens application's page in [Amazon App Store](https://www.amazon.com/gp/mas/get/amazonapp)
 */
object AmazonAppStore : AppStore {
    override fun getIntent(packageName: String) =
        StoreIntentProvider
            .Builder("$AMAZON_APP_STORE_URL$packageName")
            .withPackage(AMAZON_PACKAGE)
            .build()
}
