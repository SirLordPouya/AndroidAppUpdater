package com.pouyaheydari.androidappupdater.store.stores

import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

const val MYKET_URL = "myket://details?id="
const val MYKET_PACKAGE = "ir.mservices.market"

/**
 * Opens application's page in [Myket Store](https://myket.ir/)
 */
object MyketStore : AppStore {
    override fun getIntent(packageName: String) = StoreIntentProvider
        .Builder("$MYKET_URL$packageName")
        .withPackage(MYKET_PACKAGE)
        .build()
}
