package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentBuilder

internal const val SAMSUNG_GALAXY_STORE_URL = "samsungapps://ProductDetail/"

/**
 * Opens application's page in [Samsung Galaxy store](https://www.samsung.com/de/apps/galaxy-store/)
 */
internal data class SamsungGalaxyStore(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentBuilder
        .Builder("$SAMSUNG_GALAXY_STORE_URL$packageName")
        .build()

    override fun getType(): AppStoreType = AppStoreType.SAMSUNG_GALAXY_STORE

    override fun getUserReadableName(): String = AppStoreType.SAMSUNG_GALAXY_STORE.userReadableName

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
