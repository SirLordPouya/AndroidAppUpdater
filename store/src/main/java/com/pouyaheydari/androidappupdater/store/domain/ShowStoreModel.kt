package com.pouyaheydari.androidappupdater.store.domain

import com.pouyaheydari.androidappupdater.store.domain.stores.AppStore

data class ShowStoreModel(
    val store: AppStore = StoreFactory.getGooglePlayStore(""),
    val errorCallBack: (String) -> Unit = {},
)
