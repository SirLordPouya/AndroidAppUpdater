package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val AMAZON_APP_STORE_URL = "amzn://apps/android?p="
const val AMAZON_PACKAGE = "com.amazon.venezia"

/**
 * Opens application's page in [Amazon App Store](https://www.amazon.com/gp/mas/get/amazonapp)
 */
object AmazonAppStore : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$AMAZON_APP_STORE_URL$packageName")).run {
            setPackage(AMAZON_PACKAGE)
        }
}
