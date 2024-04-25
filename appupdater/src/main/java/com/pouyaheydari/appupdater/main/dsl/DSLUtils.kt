package com.pouyaheydari.appupdater.main.dsl

import com.pouyaheydari.appupdater.directdownload.data.model.DirectDownloadListItem
import com.pouyaheydari.appupdater.main.AppUpdaterDialog
import com.pouyaheydari.appupdater.main.pojo.UpdaterDialogData
import com.pouyaheydari.appupdater.store.domain.StoreListItem

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
