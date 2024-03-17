package com.pouyaheydari.appupdater.dsl

import com.pouyaheydari.androidappupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.androidappupdater.store.domain.StoreListItem
import com.pouyaheydari.appupdater.AppUpdaterDialog
import com.pouyaheydari.appupdater.pojo.UpdaterDialogData

/**
 * This inline function helps building stores in DSL way
 */
inline fun store(block: StoreListItem.() -> Unit): StoreListItem = StoreListItem().apply(block)

inline fun directDownload(block: DirectDownloadListItem.() -> Unit): DirectDownloadListItem = DirectDownloadListItem().apply(block)

/**
 * This inline function helps building UpdateDialog in DSL way
 */
inline fun updateDialogBuilder(block: UpdaterDialogData.() -> Unit): AppUpdaterDialog =
    AppUpdaterDialog.getInstance(UpdaterDialogData().apply(block))
