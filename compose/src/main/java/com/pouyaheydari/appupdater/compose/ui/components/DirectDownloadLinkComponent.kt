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
import com.pouyaheydari.appupdater.core.pojo.StoreListItem

/**
 * Shows direct download link's text
 *
 * @param item of type [StoreListItem] to show the title and return it in onClick event
 * @param onClickListener informs parent about selected item
 */
@Composable
internal fun DirectDownloadLinkComponent(
    item: StoreListItem,
    onClickListener: (StoreListItem) -> Unit = {},
) {
    Text(
        text = item.title,
        textAlign = TextAlign.Center,
        color = Blue,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.clickable { onClickListener(item) },
    )
}

@Preview
@Composable
private fun Preview() {
    AndroidAppUpdaterTheme {
        DirectDownloadLinkComponent(
            item = StoreListItem(title = "Direct Link 1"),
        )
    }
}
