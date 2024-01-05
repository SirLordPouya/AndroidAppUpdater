package com.pouyaheydari.appupdater.compose.ui

import android.graphics.Typeface
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pouyaheydari.appupdater.compose.ui.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.core.R as coreR

/**
 * Shows header icon, title and description
 *
 * @param dialogTitle Title of dialog
 * @param dialogDescription a brief description about the update dialog
 * @param typeface for texts
 */
@Composable
internal fun DialogHeaderComponent(
    dialogTitle: String,
    dialogDescription: String,
    typeface: Typeface?,
) {
    Column(horizontalAlignment = CenterHorizontally) {
        Image(
            painter = painterResource(id = coreR.drawable.appupdater_ic_cloud),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
        )
        Text(
            textAlign = TextAlign.Center,
            text = dialogTitle,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.titleLarge,
            fontFamily = typeface?.let { FontFamily(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
        )
        Text(
            textAlign = TextAlign.Center,
            text = dialogDescription,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyMedium,
            fontFamily = typeface?.let { FontFamily(it) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    AndroidAppUpdaterTheme {
        DialogHeaderComponent(
            dialogTitle = stringResource(id = coreR.string.appupdater_app_name),
            typeface = null,
            dialogDescription = stringResource(id = coreR.string.appupdater_download_notification_desc),
        )
    }
}
