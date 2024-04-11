package com.pouyaheydari.androidappupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

internal const val SAMSUNG_GALAXY_STORE_URL = "samsungapps://ProductDetail/"

/**
 * Opens application's page in [Samsung Galaxy store](https://www.samsung.com/de/apps/galaxy-store/)
 */
data class SamsungGalaxyStore(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentProvider
        .Builder("$SAMSUNG_GALAXY_STORE_URL$packageName")
        .build()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<SamsungGalaxyStore> {
        override fun createFromParcel(parcel: Parcel): SamsungGalaxyStore {
            return SamsungGalaxyStore(parcel)
        }

        override fun newArray(size: Int): Array<SamsungGalaxyStore?> {
            return arrayOfNulls(size)
        }
    }
}
