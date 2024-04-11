package com.pouyaheydari.appupdater.compose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.pouyaheydari.appupdater.compose.ui.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.compose.ui.theme.Blue

@Composable
internal fun DirectDownloadLinkComponent(
    modifier: Modifier = Modifier,
    title: String,
    onClickListener: () -> Unit = {},
) {
    Text(
        modifier = modifier.clickable { onClickListener() },
        text = title,
        textAlign = TextAlign.Center,
        color = Blue,
        style = MaterialTheme.typography.bodyLarge,
    )
}

@Preview
@Composable
private fun Preview() {
    AndroidAppUpdaterTheme {
        DirectDownloadLinkComponent(title = "Direct Link 1")
    }
}