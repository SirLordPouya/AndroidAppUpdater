package com.pouyaheydari.androidappupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.androidappupdater.store.domain.StoreIntentProvider

internal const val NINE_APPS_STORE_URL = "nineapps://AppDetail?id="
internal const val NINE_APPS_PACKAGE = "com.gamefun.apk2u"

/**
 * Opens application's page in [9-Apps](https://www.9apps.com/)
 */
data class NineApps(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentProvider
        .Builder("$NINE_APPS_STORE_URL$packageName")
        .withPackage(NINE_APPS_PACKAGE)
        .build()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<NineApps> {
        override fun createFromParcel(parcel: Parcel): NineApps {
            return NineApps(parcel)
        }

        override fun newArray(size: Int): Array<NineApps?> {
            return arrayOfNulls(size)
        }
    }
}
