package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentProvider

internal const val TENCENT_APP_STORE_URL = "tmast://appdetails?pname="

/**
 * Opens application's page in [Tencent App Store](https://appstore.tencent.com/)
 */
internal data class TencentAppStore(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentProvider
        .Builder("$TENCENT_APP_STORE_URL$packageName")
        .build()

    override fun getType(): AppStoreType = AppStoreType.TENCENT_APPS_STORE

    override fun getUserReadableName(): String = AppStoreType.TENCENT_APPS_STORE.userReadableName

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<TencentAppStore> {
        override fun createFromParcel(parcel: Parcel): TencentAppStore {
            return TencentAppStore(parcel)
        }

        override fun newArray(size: Int): Array<TencentAppStore?> {
            return arrayOfNulls(size)
        }
    }
}
