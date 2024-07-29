package com.pouyaheydari.appupdater.store.domain

import android.content.ActivityNotFoundException
import android.content.Context
import com.pouyaheydari.appupdater.store.domain.stores.AppStore

fun showAppInSelectedStore(context: Context?, store: AppStore, callback: (AppStoreCallback) -> Unit) {
    try {
        val intent = store.getIntent()
        context?.startActivity(intent)
        callback(AppStoreCallback.Success(store))
    } catch (exception: ActivityNotFoundException) {
        callback(AppStoreCallback.Failure(store, exception))
    }
}
