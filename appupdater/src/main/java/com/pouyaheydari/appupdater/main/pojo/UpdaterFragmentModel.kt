package com.pouyaheydari.appupdater.main.pojo

import android.os.Parcel
import android.os.Parcelable
import com.pouyaheydari.appupdater.core.model.Theme
import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.store.domain.StoreListItem

/**
 * This model is used to pass the data to dialog fragment via bundles
 */
data class UpdaterFragmentModel(
    var title: String = "",
    var description: String = "",
    var storeList: List<StoreListItem> = listOf(),
    var directDownloadList: List<DirectDownloadListItem> = listOf(),
    var isForceUpdate: Boolean = false,
    var theme: Theme = Theme.SYSTEM_DEFAULT,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.createTypedArrayList(StoreListItem).orEmpty(),
        parcel.createTypedArrayList(DirectDownloadListItem).orEmpty(),
        parcel.readByte() != 0.toByte(),
        Theme.entries[parcel.readInt()],
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeTypedList(storeList)
        parcel.writeByte(if (isForceUpdate) 1 else 0)
        parcel.writeInt(theme.ordinal)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UpdaterFragmentModel> {
        val EMPTY = UpdaterFragmentModel()
        override fun createFromParcel(parcel: Parcel): UpdaterFragmentModel {
            return UpdaterFragmentModel(parcel)
        }

        override fun newArray(size: Int): Array<UpdaterFragmentModel?> {
            return arrayOfNulls(size)
        }
    }
}