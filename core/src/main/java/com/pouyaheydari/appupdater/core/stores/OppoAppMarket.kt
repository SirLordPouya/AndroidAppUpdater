package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.StoreIntentProvider

const val OPPO_APP_MARKET_URL = "market://details?id="
const val OPPO_PACKAGE = "com.heytap.market"

/**
 * Opens application's page in [OppoAppMarket](https://oppomobile.com/)
 */
object OppoAppMarket : AppStore {
    override fun getIntent(packageName: String) = StoreIntentProvider
        .Builder("$OPPO_APP_MARKET_URL$packageName")
        .withPackage(OPPO_PACKAGE)
        .build()
}
