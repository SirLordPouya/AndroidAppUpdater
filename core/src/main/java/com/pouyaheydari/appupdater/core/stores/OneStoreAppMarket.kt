package com.pouyaheydari.appupdater.core.stores

import android.content.Intent
import android.net.Uri

const val ONE_STORE_APP_MARKET_URL = "onestore://common/product/"

/**
 * Opens application's page in [OneStore App Market](https://m.onestore.co.kr/mobilepoc/main/main.omp)
 */
object OneStoreAppMarket : AppStore {
    override fun getIntent(packageName: String) =
        Intent(Intent.ACTION_VIEW, Uri.parse("$ONE_STORE_APP_MARKET_URL$packageName"))
}
