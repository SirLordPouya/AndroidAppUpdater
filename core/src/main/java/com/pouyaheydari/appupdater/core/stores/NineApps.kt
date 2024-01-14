package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.StoreIntentProvider

const val NINE_APPS_STORE_URL = "nineapps://AppDetail?id="
const val NINE_APPS_PACKAGE = "com.gamefun.apk2u"

/**
 * Opens application's page in [9-Apps](https://www.9apps.com/)
 */
object NineApps : AppStore {
    override fun getIntent(packageName: String) = StoreIntentProvider
        .Builder("$NINE_APPS_STORE_URL$packageName")
        .withPackage(NINE_APPS_PACKAGE)
        .build()
}
