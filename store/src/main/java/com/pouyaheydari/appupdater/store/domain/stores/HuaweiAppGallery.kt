package com.pouyaheydari.appupdater.store.domain.stores

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.store.domain.StoreIntentBuilder

internal const val HUAWEI_APP_GALLERY_URL = "appmarket://details?id="
internal const val HUAWEI_APP_GALLERY_PACKAGE = "com.huawei.appmarket"

/**
 * Opens application's page in [Huawei App Gallery](https://appgallery.huawei.com/)
 */
internal data class HuaweiAppGallery(val packageName: String) : AppStore {
    constructor(parcel: Parcel) : this(parcel.readString().orEmpty())

    override fun getIntent() = StoreIntentBuilder
        .Builder("$HUAWEI_APP_GALLERY_URL$packageName")
        .withPackage(HUAWEI_APP_GALLERY_PACKAGE)
        .build()

    override fun getType(): AppStoreType = AppStoreType.HUAWEI_APP_GALLERY

    override fun getUserReadableName(): String = AppStoreType.HUAWEI_APP_GALLERY.userReadableName

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(packageName)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<HuaweiAppGallery> {
        override fun createFromParcel(parcel: Parcel): HuaweiAppGallery {
            return HuaweiAppGallery(parcel)
        }

        override fun newArray(size: Int): Array<HuaweiAppGallery?> {
            return arrayOfNulls(size)
        }
    }
}
