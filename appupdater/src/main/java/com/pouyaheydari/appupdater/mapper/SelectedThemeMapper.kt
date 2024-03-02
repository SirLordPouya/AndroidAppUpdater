package com.pouyaheydari.appupdater.mapper

import android.content.Context
import android.content.res.Configuration
import com.pouyaheydari.androidappupdater.store.model.Theme
import com.pouyaheydari.androidappupdater.store.model.Theme.DARK
import com.pouyaheydari.androidappupdater.store.model.Theme.LIGHT
import com.pouyaheydari.androidappupdater.store.model.Theme.SYSTEM_DEFAULT
import com.pouyaheydari.appupdater.pojo.UserSelectedTheme

/**
 * Maps the user selected theme to either [UserSelectedTheme.LIGHT] or [UserSelectedTheme.DARK]
 *
 * @param theme Selected theme by the user
 * @param context Android context to get the system theme
 */
internal fun mapToSelectedTheme(theme: Theme, context: Context): UserSelectedTheme = when (theme) {
    LIGHT -> UserSelectedTheme.LIGHT
    DARK -> UserSelectedTheme.DARK
    SYSTEM_DEFAULT -> if (context.isSystemInDarkMode()) UserSelectedTheme.DARK else UserSelectedTheme.LIGHT
}

private fun Context.isSystemInDarkMode(): Boolean =
    resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
