package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.StoreIntentProvider

const val V_APP_STORE_URL = "vivoMarket://details?id="

/**
 * Opens application's page in [V-AppStore](https://developer.vivo.com/home)
 */
object VAppStore : AppStore {
    override fun getIntent(packageName: String) = StoreIntentProvider
        .Builder("$V_APP_STORE_URL$packageName")
        .build()
}
