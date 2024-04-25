package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentProvider

internal const val OPPO_APP_MARKET_URL = "market://details?id="
internal const val OPPO_PACKAGE = "com.heytap.market"

/**
 * Opens application's page in [OppoAppMarket](https://oppomobile.com/)
 */
data class OppoAppMarket(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentProvider
        .Builder("$OPPO_APP_MARKET_URL$packageName")
        .withPackage(OPPO_PACKAGE)
        .build()

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<OppoAppMarket> {
        override fun createFromParcel(parcel: Parcel): OppoAppMarket {
            return OppoAppMarket(parcel)
        }

        override fun newArray(size: Int): Array<OppoAppMarket?> {
            return arrayOfNulls(size)
        }
    }
}
