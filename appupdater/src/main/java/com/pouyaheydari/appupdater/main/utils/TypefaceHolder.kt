package com.pouyaheydari.appupdater.main.utils

import android.graphics.Typeface

/**
 * Holds an instance of [Typeface] to be used in dialogs while being shown.
 */
internal object TypefaceHolder {
    var typeface: Typeface? = null

    fun clear() {
        typeface = null
    }
}
