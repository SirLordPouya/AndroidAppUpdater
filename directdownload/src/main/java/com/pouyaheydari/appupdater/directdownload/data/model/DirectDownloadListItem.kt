package com.pouyaheydari.appupdater.directdownload.data.model

import android.os.Parcel
import android.os.Parcelable

data class DirectDownloadListItem(var title: String = "", var url: String = "") : Parcelable {
    private constructor(parcel: Parcel) : this(
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(url)
    }

    companion object CREATOR : Parcelable.Creator<DirectDownloadListItem> {
        override fun createFromParcel(parcel: Parcel): DirectDownloadListItem {
            return DirectDownloadListItem(parcel)
        }

        override fun newArray(size: Int): Array<DirectDownloadListItem?> {
            return arrayOfNulls(size)
        }
    }
}
