package com.pouyaheydari.appupdater.compose.utils

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.pouyaheydari.appupdater.core.model.Theme

/**
 * Returns if the dialog should be shown in dark mode based on the user selected [theme]
 */
@Composable
internal fun isDarkThemeSelected(theme: Theme): Boolean = when (theme) {
    Theme.DARK -> true
    Theme.LIGHT -> false
    Theme.SYSTEM_DEFAULT -> isSystemInDarkTheme()
}
