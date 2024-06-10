package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentProvider

internal const val ONE_STORE_APP_MARKET_URL = "onestore://common/product/"

/**
 * Opens application's page in [OneStore App Market](https://m.onestore.co.kr/mobilepoc/main/main.omp)
 */
internal data class OneStoreAppMarket(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() =
        StoreIntentProvider
            .Builder("$ONE_STORE_APP_MARKET_URL$packageName")
            .build()

    override fun getType(): AppStoreType = AppStoreType.ONE_STORE_APP_MARKET

    override fun getUserReadableName(): String = AppStoreType.ONE_STORE_APP_MARKET.userReadableName

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<OneStoreAppMarket> {
        override fun createFromParcel(parcel: Parcel): OneStoreAppMarket {
            return OneStoreAppMarket(parcel)
        }

        override fun newArray(size: Int): Array<OneStoreAppMarket?> {
            return arrayOfNulls(size)
        }
    }
}
