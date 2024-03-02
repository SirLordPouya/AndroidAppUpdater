package com.pouyaheydari.androidappupdater.store.stores

import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

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
