package com.pouyaheydari.androidappupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

internal const val BAZAAR_URL = "bazaar://details?id="
internal const val BAZAAR_PACKAGE = "com.farsitel.bazaar"

/**
 * Opens application's page in [CafeBazaar App Store](https://cafebazaar.ir)
 */
data class CafeBazaarStore(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentProvider
        .Builder("$BAZAAR_URL$packageName")
        .withPackage(BAZAAR_PACKAGE)
        .build()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<CafeBazaarStore> {
        override fun createFromParcel(parcel: Parcel): CafeBazaarStore {
            return CafeBazaarStore(parcel)
        }

        override fun newArray(size: Int): Array<CafeBazaarStore?> {
            return arrayOfNulls(size)
        }
    }
}
