package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentBuilder

internal const val LENOVO_APP_CENTER_URL = "leapp://ptn/appinfo.do?pn="

/**
 * Opens application's page in [Lenovo App Store](https://www.lenovomm.com/)
 */
internal data class LenovoAppCenter(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentBuilder
        .Builder("$LENOVO_APP_CENTER_URL$packageName")
        .build()

    override fun getType(): AppStoreType = AppStoreType.LENOVO_APP_CENTER

    override fun getUserReadableName(): String = AppStoreType.LENOVO_APP_CENTER.userReadableName

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<LenovoAppCenter> {
        override fun createFromParcel(parcel: Parcel): LenovoAppCenter {
            return LenovoAppCenter(parcel)
        }

        override fun newArray(size: Int): Array<LenovoAppCenter?> {
            return arrayOfNulls(size)
        }
    }
}
