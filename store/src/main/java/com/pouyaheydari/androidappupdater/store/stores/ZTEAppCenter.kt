package com.pouyaheydari.androidappupdater.store.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

const val ZTE_APP_CENTER_URL = "zte_market://appdetails?pname="

/**
 * Opens application's page in [ZTE App Store](https://apps.ztems.com/)
 */
data class ZTEAppCenter(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentProvider
        .Builder("$ZTE_APP_CENTER_URL$packageName")
        .build()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ZTEAppCenter> {
        override fun createFromParcel(parcel: Parcel): ZTEAppCenter {
            return ZTEAppCenter(parcel)
        }

        override fun newArray(size: Int): Array<ZTEAppCenter?> {
            return arrayOfNulls(size)
        }
    }
}
