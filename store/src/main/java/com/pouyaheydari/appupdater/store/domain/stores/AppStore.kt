package com.pouyaheydari.appupdater.store.domain.stores

import android.content.Intent
import android.os.Parcelable

sealed interface AppStore : Parcelable {
    fun getIntent(): Intent
}
