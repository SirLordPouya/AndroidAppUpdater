package com.pouyaheydari.appupdater.compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pouyaheydari.appupdater.compose.ui.theme.AndroidAppUpdaterTheme
import com.pouyaheydari.appupdater.core.R
import com.pouyaheydari.appupdater.core.pojo.StoreListItem

/**
 * Shows stores in a square shape
 *
 * @param item of type [StoreListItem] to show the title and return it in onClick event
 * @param onClickListener informs parent about selected item
 */
@Composable
internal fun SquareStoreItemComponent(
    item: StoreListItem,
    onClickListener: (StoreListItem) -> Unit = {},
) {
    Column(
        modifier = Modifier.clickable { onClickListener(item) },
        horizontalAlignment = CenterHorizontally,
    ) {
        Image(painter = painterResource(id = item.icon), contentDescription = null)
        Text(
            text = item.title,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(top = 8.dp),
        )
    }
}

@Preview
@Composable
private fun Preview() {
    AndroidAppUpdaterTheme {
        SquareStoreItemComponent(item = StoreListItem(icon = R.drawable.appupdater_ic_google_play))
    }
}
