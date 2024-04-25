package com.pouyaheydari.appupdater.store.domain

import android.os.Parcel
import android.os.Parcelable
import androidx.core.os.ParcelCompat
import com.pouyaheydari.appupdater.store.R
import com.pouyaheydari.appupdater.store.domain.stores.AppStore

/**
 * The model that we are using for list of stores
 */
data class StoreListItem(
    var store: AppStore = StoreFactory.getGooglePlayStore(""),
    var title: String = "",
    var icon: Int = R.drawable.appupdater_ic_cloud,
    var url: String = "",
) : Parcelable {
    private constructor(parcel: Parcel) : this(
        ParcelCompat.readParcelable(parcel, AppStore::class.java.classLoader, AppStore::class.java) ?: StoreFactory.getGooglePlayStore(""),
        parcel.readString().orEmpty(),
        parcel.readInt(),
        parcel.readString().orEmpty(),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(store, flags)
        parcel.writeString(title)
        parcel.writeInt(icon)
        parcel.writeString(url)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<StoreListItem> {
        override fun createFromParcel(parcel: Parcel): StoreListItem {
            return StoreListItem(parcel)
        }

        override fun newArray(size: Int): Array<StoreListItem?> {
            return arrayOfNulls(size)
        }
    }
}
