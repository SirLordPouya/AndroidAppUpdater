package com.pouyaheydari.androidappupdater.store

import com.pouyaheydari.androidappupdater.store.domain.StoreFactory
import com.pouyaheydari.androidappupdater.store.stores.AppStore

data class ShowStoreModel(
    val store: AppStore = StoreFactory.getGooglePlayStore(""),
    val fallbackUrl: String = "",
    val errorCallBack: () -> Unit = {},
)
