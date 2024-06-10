package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentProvider

internal const val V_APP_STORE_URL = "vivoMarket://details?id="

/**
 * Opens application's page in [V-AppStore](https://developer.vivo.com/home)
 */
internal data class VAppStore(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentProvider
        .Builder("$V_APP_STORE_URL$packageName")
        .build()

    override fun getType(): AppStoreType = AppStoreType.V_APP_STORE

    override fun getUserReadableName(): String = AppStoreType.V_APP_STORE.userReadableName

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
