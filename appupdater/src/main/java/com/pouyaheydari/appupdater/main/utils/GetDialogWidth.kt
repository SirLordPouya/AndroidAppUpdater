package com.pouyaheydari.appupdater.main.utils

import android.content.res.Resources
import android.graphics.Rect

/**
 * Calculates dialog's widths to only cover a certain percentage of the screen
 *
 * @param percentage of the device to be covered by the dialog
 */
internal fun getDialogWidth(percentage: Int = 80): Int {
    val percent = percentage.toFloat() / 100
    val dm = Resources.getSystem().displayMetrics
    val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
    return (rect.width() * percent).toInt()
}
