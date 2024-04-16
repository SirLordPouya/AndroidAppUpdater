package com.pouyaheydari.appupdater.compose.ui.components

import android.graphics.Typeface
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.pouyaheydari.appupdater.compose.ui.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.core.R

/**
 * Shows a divider between direct download links and stores
 */
@Composable
internal fun DividerComponent(
    modifier: Modifier = Modifier,
    dividerText: String = "",
    typeface: Typeface? = null,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth(),
    ) {
        HorizontalDivider(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .weight(1F)
                .padding(start = 16.dp, end = 8.dp),
        )

        Text(text = dividerText, fontFamily = typeface?.let { FontFamily(it) })

        HorizontalDivider(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .weight(1F)
                .padding(start = 8.dp, end = 16.dp),
        )
    }
}

@PreviewLightDark
@PreviewFontScale
@PreviewScreenSizes
@Composable
private fun Preview() {
    AndroidAppUpdaterTheme {
        DividerComponent(dividerText = stringResource(id = R.string.appupdater_or))
    }
}
