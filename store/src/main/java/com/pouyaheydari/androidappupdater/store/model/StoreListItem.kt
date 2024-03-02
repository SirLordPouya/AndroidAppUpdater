package com.pouyaheydari.androidappupdater.store.model

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.core.R as coreR

/**
 * The model that we are using for list of stores
 */
data class StoreListItem(
    var store: Store = Store.DIRECT_URL,
    var title: String = "",
    var icon: Int = coreR.drawable.appupdater_ic_cloud,
    var url: String = "",
    var packageName: String = "",
) : Parcelable {
    constructor(parcel: Parcel) : this(
        Store.entries[parcel.readInt()],
        parcel.readString().orEmpty(),
        parcel.readInt(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(store.ordinal)
        parcel.writeString(title)
        parcel.writeInt(icon)
        parcel.writeString(url)
        parcel.writeString(packageName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StoreListItem> {
        override fun createFromParcel(parcel: Parcel): StoreListItem {
            return StoreListItem(parcel)
        }

        override fun newArray(size: Int): Array<StoreListItem?> {
            return arrayOfNulls(size)
        }
    }
}
