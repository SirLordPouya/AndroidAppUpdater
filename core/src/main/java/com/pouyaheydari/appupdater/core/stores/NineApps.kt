package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.AndroidIntentBuilder

const val NINE_APPS_STORE_URL = "nineapps://AppDetail?id="
const val NINE_APPS_PACKAGE = "com.gamefun.apk2u"

/**
 * Opens application's page in [9-Apps](https://www.9apps.com/)
 */
object NineApps : AppStore {
    override fun getIntent(packageName: String) = AndroidIntentBuilder
        .addUriString("$NINE_APPS_STORE_URL$packageName")
        .addPackage(NINE_APPS_PACKAGE)
        .build()
}
