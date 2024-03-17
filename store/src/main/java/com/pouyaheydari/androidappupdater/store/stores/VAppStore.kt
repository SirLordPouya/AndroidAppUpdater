package com.pouyaheydari.androidappupdater.store.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

const val V_APP_STORE_URL = "vivoMarket://details?id="

/**
 * Opens application's page in [V-AppStore](https://developer.vivo.com/home)
 */
data class VAppStore(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentProvider
        .Builder("$V_APP_STORE_URL$packageName")
        .build()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<VAppStore> {
        override fun createFromParcel(parcel: Parcel): VAppStore {
            return VAppStore(parcel)
        }

        override fun newArray(size: Int): Array<VAppStore?> {
            return arrayOfNulls(size)
        }
    }
}
