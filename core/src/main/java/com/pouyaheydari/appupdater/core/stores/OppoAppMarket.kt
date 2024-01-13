package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val OPPO_APP_MARKET_URL = "market://details?id="
const val OPPO_PACKAGE = "com.heytap.market"

/**
 * Opens application's page in [OppoAppMarket](https://oppomobile.com/)
 */
object OppoAppMarket : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$OPPO_APP_MARKET_URL$packageName")).run {
            setPackage(OPPO_PACKAGE)
        }
}
