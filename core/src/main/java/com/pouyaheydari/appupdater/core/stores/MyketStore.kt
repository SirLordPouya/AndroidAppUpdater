package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.AndroidIntentBuilder

const val MYKET_URL = "myket://details?id="
const val MYKET_PACKAGE = "ir.mservices.market"

/**
 * Opens application's page in [Myket Store](https://myket.ir/)
 */
object MyketStore : AppStore {
    override fun getIntent(packageName: String) = AndroidIntentBuilder
        .addUriString("$MYKET_URL$packageName")
        .addPackage(MYKET_PACKAGE)
        .build()
}
