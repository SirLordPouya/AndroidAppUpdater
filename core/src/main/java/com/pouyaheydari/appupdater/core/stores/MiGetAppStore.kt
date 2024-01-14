package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.AndroidIntentBuilder

const val MI_APP_STORE_URL = "mimarket://details?id="

/**
 * Opens application's page in [Xiaomi GetApp store](https://global.app.mi.com/)
 */
object MiGetAppStore : AppStore {
    override fun getIntent(packageName: String) =
        AndroidIntentBuilder
            .addUriString("$MI_APP_STORE_URL$packageName")
            .build()
}
