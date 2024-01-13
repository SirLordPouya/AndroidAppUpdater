package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val ZTE_APP_CENTER_URL = "zte_market://appdetails?pname="

/**
 * Opens application's page in [ZTE App Store](https://apps.ztems.com/)
 */
object ZTEAppCenter : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$ZTE_APP_CENTER_URL$packageName"))
}
