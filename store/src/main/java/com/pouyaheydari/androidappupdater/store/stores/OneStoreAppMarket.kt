package com.pouyaheydari.androidappupdater.store.stores

import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

const val ONE_STORE_APP_MARKET_URL = "onestore://common/product/"

/**
 * Opens application's page in [OneStore App Market](https://m.onestore.co.kr/mobilepoc/main/main.omp)
 */
object OneStoreAppMarket : AppStore {
    override fun getIntent(packageName: String) =
        StoreIntentProvider
            .Builder("$ONE_STORE_APP_MARKET_URL$packageName")
            .build()
}
