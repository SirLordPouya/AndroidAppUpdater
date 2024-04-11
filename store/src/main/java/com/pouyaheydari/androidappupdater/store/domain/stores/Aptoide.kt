package com.pouyaheydari.androidappupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

internal const val APTOIDE_URL = "aptoideinstall://package="
internal const val APTOIDE_PACKAGE = "cm.aptoide.pt"

/**
 * Opens application's page in [Aptoide App Store](https://en.aptoide.com/)
 */
data class Aptoide(val packageName: String) : AppStore {
    private constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentProvider
        .Builder("$APTOIDE_URL$packageName")
        .withPackage(APTOIDE_PACKAGE)
        .build()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Aptoide> {
        override fun createFromParcel(parcel: Parcel): Aptoide {
            return Aptoide(parcel)
        }

        override fun newArray(size: Int): Array<Aptoide?> {
            return arrayOfNulls(size)
        }
    }
}
