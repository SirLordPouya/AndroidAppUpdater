package com.pouyaheydari.androidappupdater.store.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

const val TENCENT_APP_STORE_URL = "tmast://appdetails?pname="

/**
 * Opens application's page in [Tencent App Store](https://appstore.tencent.com/)
 */
data class TencentAppStore(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentProvider
        .Builder("$TENCENT_APP_STORE_URL$packageName")
        .build()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<TencentAppStore> {
        override fun createFromParcel(parcel: Parcel): TencentAppStore {
            return TencentAppStore(parcel)
        }

        override fun newArray(size: Int): Array<TencentAppStore?> {
            return arrayOfNulls(size)
        }
    }
}
