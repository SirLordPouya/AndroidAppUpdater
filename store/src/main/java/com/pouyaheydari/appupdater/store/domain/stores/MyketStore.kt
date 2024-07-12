package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentBuilder

internal const val MYKET_URL = "myket://details?id="
internal const val MYKET_PACKAGE = "ir.mservices.market"

/**
 * Opens application's page in [Myket Store](https://myket.ir/)
 */
internal data class MyketStore(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentBuilder
        .Builder("$MYKET_URL$packageName")
        .withPackage(MYKET_PACKAGE)
        .build()

    override fun getType(): AppStoreType = AppStoreType.MYKET

    override fun getUserReadableName(): String = AppStoreType.MYKET.userReadableName

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<MyketStore> {
        override fun createFromParcel(parcel: Parcel): MyketStore {
            return MyketStore(parcel)
        }

        override fun newArray(size: Int): Array<MyketStore?> {
            return arrayOfNulls(size)
        }
    }
}