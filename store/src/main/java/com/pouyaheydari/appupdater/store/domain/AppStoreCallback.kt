package com.pouyaheydari.appupdater.store.domain

import android.content.ActivityNotFoundException
import com.pouyaheydari.appupdater.store.domain.stores.AppStore

sealed interface AppStoreCallback {
    data class Success(val store: AppStore) : AppStoreCallback
    data class Failure(val store: AppStore, val exception: ActivityNotFoundException) : AppStoreCallback
}
