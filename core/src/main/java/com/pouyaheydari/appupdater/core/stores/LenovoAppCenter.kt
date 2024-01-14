package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.AndroidIntentBuilder

const val LENOVO_APP_CENTER_URL = "leapp://ptn/appinfo.do?pn="

/**
 * Opens application's page in [Lenovo App Store](https://www.lenovomm.com/)
 */
object LenovoAppCenter : AppStore {
    override fun getIntent(packageName: String) = AndroidIntentBuilder
        .addUriString("$LENOVO_APP_CENTER_URL$packageName")
        .build()
}
