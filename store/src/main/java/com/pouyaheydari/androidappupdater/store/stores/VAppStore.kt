package com.pouyaheydari.androidappupdater.store.stores

import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

const val V_APP_STORE_URL = "vivoMarket://details?id="

/**
 * Opens application's page in [V-AppStore](https://developer.vivo.com/home)
 */
object VAppStore : AppStore {
    override fun getIntent(packageName: String) = StoreIntentProvider
        .Builder("$V_APP_STORE_URL$packageName")
        .build()
}
