package com.pouyaheydari.appupdater.utils

import android.graphics.Typeface

/**
 * Holds an instance of [Typeface] to be used in dialogs while being shown.
 */
internal object ErrorCallbackHolder {
    var callback: ((String) -> Unit)? = null

    fun clear() {
        callback = null
    }
}
