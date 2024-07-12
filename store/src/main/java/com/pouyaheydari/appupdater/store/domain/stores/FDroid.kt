package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentBuilder

internal const val FDROID_URL = "fdroid.app://details?id="
internal const val FDROID_PACKAGE = "org.fdroid.fdroid"

/**
 * Opens application's page in [F-Droid App Store](https://f-droid.org/)
 */
internal data class FDroid(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentBuilder
        .Builder("$FDROID_URL$packageName")
        .withPackage(FDROID_PACKAGE)
        .build()

    override fun getType(): AppStoreType = AppStoreType.FDROID

    override fun getUserReadableName(): String = AppStoreType.FDROID.userReadableName

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<FDroid> {
        override fun createFromParcel(parcel: Parcel): FDroid {
            return FDroid(parcel)
        }

        override fun newArray(size: Int): Array<FDroid?> {
            return arrayOfNulls(size)
        }
    }
}