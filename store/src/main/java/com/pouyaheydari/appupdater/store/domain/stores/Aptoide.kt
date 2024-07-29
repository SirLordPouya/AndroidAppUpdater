package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentBuilder

internal const val APTOIDE_URL = "aptoideinstall://package="
internal const val APTOIDE_PACKAGE = "cm.aptoide.pt"

/**
 * Opens application's page in [Aptoide App Store](https://en.aptoide.com/)
 */
internal data class Aptoide(val packageName: String) : AppStore {
    private constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentBuilder
        .Builder("$APTOIDE_URL$packageName")
        .withPackage(APTOIDE_PACKAGE)
        .build()

    override fun getType(): AppStoreType = AppStoreType.APTOIDE

    override fun getUserReadableName(): String = AppStoreType.APTOIDE.userReadableName

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
