package com.pouyaheydari.appupdater.core.data.model

data class ShowStoreModel(
    val packageName: String = "",
    val store: Store = Store.GOOGLE_PLAY,
    val fallbackUrl: String = "",
    val errorCallBack: () -> Unit = {},
)
