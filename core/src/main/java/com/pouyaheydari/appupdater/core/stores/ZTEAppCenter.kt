package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.AndroidIntentBuilder

const val ZTE_APP_CENTER_URL = "zte_market://appdetails?pname="

/**
 * Opens application's page in [ZTE App Store](https://apps.ztems.com/)
 */
object ZTEAppCenter : AppStore {
    override fun getIntent(packageName: String) = AndroidIntentBuilder
        .addUriString("$ZTE_APP_CENTER_URL$packageName")
        .build()
}
