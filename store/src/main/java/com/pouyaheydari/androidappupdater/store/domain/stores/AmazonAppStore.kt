package com.pouyaheydari.androidappupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

internal const val AMAZON_APP_STORE_URL = "amzn://apps/android?p="
internal const val AMAZON_PACKAGE = "com.amazon.venezia"

/**
 * Opens application's page in [Amazon App Store](https://www.amazon.com/gp/mas/get/amazonapp)
 */
data class AmazonAppStore(val packageName: String) : AppStore {
    private constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() =
        StoreIntentProvider
            .Builder("$AMAZON_APP_STORE_URL$packageName")
            .withPackage(AMAZON_PACKAGE)
            .build()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<AmazonAppStore> {
        override fun createFromParcel(parcel: Parcel): AmazonAppStore {
            return AmazonAppStore(parcel)
        }

        override fun newArray(size: Int): Array<AmazonAppStore?> {
            return arrayOfNulls(size)
        }
    }
}
