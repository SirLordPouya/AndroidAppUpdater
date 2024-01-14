package com.pouyaheydari.appupdater.core.stores

import com.pouyaheydari.appupdater.core.utils.StoreIntentProvider

const val APTOIDE_URL = "aptoideinstall://package="
const val APTOIDE_PACKAGE = "cm.aptoide.pt"

/**
 * Opens application's page in [Aptoide App Store](https://en.aptoide.com/)
 */
object Aptoide : AppStore {
    override fun getIntent(packageName: String) = StoreIntentProvider
        .Builder("$APTOIDE_URL$packageName")
        .withPackage(APTOIDE_PACKAGE)
        .build()
}
