package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val NINE_APPS_STORE_URL = "nineapps://AppDetail?id="
const val NINE_APPS_PACKAGE = "com.gamefun.apk2u"

/**
 * Opens application's page in [9-Apps](https://www.9apps.com/)
 */
object NineApps : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$NINE_APPS_STORE_URL$packageName")).run {
            setPackage(NINE_APPS_PACKAGE)
        }
}
