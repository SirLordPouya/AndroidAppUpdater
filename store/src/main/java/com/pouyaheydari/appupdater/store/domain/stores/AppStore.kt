package com.pouyaheydari.appupdater.store.domain.stores

import android.content.Intent
import android.os.Parcelable

interface AppStore : Parcelable {
    fun getIntent(): Intent
    fun getType(): AppStoreType
    fun getUserReadableName(): String
}
