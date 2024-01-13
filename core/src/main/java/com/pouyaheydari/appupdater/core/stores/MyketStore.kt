package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val MYKET_URL = "myket://details?id="
const val MYKET_PACKAGE = "ir.mservices.market"

/**
 * Opens application's page in [Myket Store](https://myket.ir/)
 */
object MyketStore : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$MYKET_URL$packageName")).run {
            setPackage(MYKET_PACKAGE)
        }
}
