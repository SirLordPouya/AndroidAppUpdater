package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.StoreIntentProvider

const val MI_APP_STORE_URL = "mimarket://details?id="

/**
 * Opens application's page in [Xiaomi GetApp store](https://global.app.mi.com/)
 */
object MiGetAppStore : AppStore {
    override fun getIntent(packageName: String) =
        StoreIntentProvider
            .Builder("$MI_APP_STORE_URL$packageName")
            .build()
}
