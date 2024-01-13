package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val LENOVO_APP_CENTER_URL = "leapp://ptn/appinfo.do?pn="

/**
 * Opens application's page in [Lenovo App Store](https://www.lenovomm.com/)
 */
object LenovoAppCenter : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$LENOVO_APP_CENTER_URL$packageName"))
}
