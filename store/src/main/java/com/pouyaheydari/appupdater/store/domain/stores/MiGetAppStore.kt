package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentProvider

internal const val MI_APP_STORE_URL = "mimarket://details?id="

/**
 * Opens application's page in [Xiaomi GetApp store](https://global.app.mi.com/)
 */
data class MiGetAppStore(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() =
        StoreIntentProvider
            .Builder("$MI_APP_STORE_URL$packageName")
            .build()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<MiGetAppStore> {
        override fun createFromParcel(parcel: Parcel): MiGetAppStore {
            return MiGetAppStore(parcel)
        }

        override fun newArray(size: Int): Array<MiGetAppStore?> {
            return arrayOfNulls(size)
        }
    }
}
