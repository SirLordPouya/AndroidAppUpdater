package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentProvider

internal const val PLAY_URL = "market://details?id="
internal const val PLAY_PACKAGE = "com.android.vending"

/**
 * Opens application's page in [GooglePlay Store](https://play.google.com)
 */
internal data class GooglePlayStore(val packageName: String) : AppStore {
    private constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentProvider
        .Builder("$PLAY_URL$packageName")
        .withPackage(PLAY_PACKAGE)
        .build()

    override fun getType(): AppStoreType = AppStoreType.GOOGLE_PLAY

    override fun getUserReadableName(): String = AppStoreType.GOOGLE_PLAY.userReadableName

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<GooglePlayStore> {
        override fun createFromParcel(parcel: Parcel): GooglePlayStore {
            return GooglePlayStore(parcel)
        }

        override fun newArray(size: Int): Array<GooglePlayStore?> {
            return arrayOfNulls(size)
        }
    }
}
