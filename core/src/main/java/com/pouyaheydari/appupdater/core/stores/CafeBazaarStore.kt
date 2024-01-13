package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val BAZAAR_URL = "bazaar://details?id="
const val BAZAAR_PACKAGE = "com.farsitel.bazaar"

/**
 * Opens application's page in [CafeBazaar App Store](https://cafebazaar.ir)
 */
object CafeBazaarStore : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$BAZAAR_URL$packageName")).run {
            setPackage(BAZAAR_PACKAGE)
        }
}
