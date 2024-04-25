package com.pouyaheydari.appupdater.store.domain

import com.pouyaheydari.appupdater.store.domain.stores.AppStore

data class ShowStoreModel(
    val store: AppStore = StoreFactory.getGooglePlayStore(""),
    val errorCallBack: (String) -> Unit = {},
)
