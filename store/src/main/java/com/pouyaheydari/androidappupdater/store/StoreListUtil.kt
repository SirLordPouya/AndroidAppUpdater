package com.pouyaheydari.androidappupdater.store

import com.pouyaheydari.androidappupdater.store.model.StoreListItem

fun shouldShowStoresDivider(directDownloadList: List<StoreListItem>, storeList: List<StoreListItem>): Boolean =
    directDownloadList.isNotEmpty() && storeList.isNotEmpty()
