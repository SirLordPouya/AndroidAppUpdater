package com.pouyaheydari.androidappupdater.store.stores

import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

const val TENCENT_APP_STORE_URL = "tmast://appdetails?pname="

/**
 * Opens application's page in [Tencent App Store](https://appstore.tencent.com/)
 */
object TencentAppStore : AppStore {
    override fun getIntent(packageName: String) = StoreIntentProvider
        .Builder("$TENCENT_APP_STORE_URL$packageName")
        .build()
}
