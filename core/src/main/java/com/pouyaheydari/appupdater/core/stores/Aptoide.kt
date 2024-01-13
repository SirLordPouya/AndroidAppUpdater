package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val APTOIDE_URL = "aptoideinstall://package="
const val APTOIDE_PACKAGE = "cm.aptoide.pt"

/**
 * Opens application's page in [Aptoide App Store](https://en.aptoide.com/)
 */
object Aptoide : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$APTOIDE_URL$packageName")).run {
            setPackage(APTOIDE_PACKAGE)
        }
}
