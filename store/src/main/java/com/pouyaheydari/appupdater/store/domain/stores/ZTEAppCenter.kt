package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentBuilder

internal const val ZTE_APP_CENTER_URL = "zte_market://appdetails?pname="

/**
 * Opens application's page in [ZTE App Store](https://apps.ztems.com/)
 */
internal data class ZTEAppCenter(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentBuilder
        .Builder("$ZTE_APP_CENTER_URL$packageName")
        .build()

    override fun getType(): AppStoreType = AppStoreType.ZTE_APP_CENTER

    override fun getUserReadableName(): String = AppStoreType.ZTE_APP_CENTER.userReadableName

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
