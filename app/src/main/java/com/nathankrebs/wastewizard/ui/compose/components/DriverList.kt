package com.nathankrebs.wastewizard.ui.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nathankrebs.wastewizard.R
import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.ui.theme.listItemPadding

/**
 * Show a list of [DriverItem]
 *
 * @param drivers The list of [DriverItem] to show in the list
 * @param onDriverClick Callback when a particular driver from within [drivers] is clicked
 */
@Composable
fun DriverList(
    drivers: List<DriverItem>,
    modifier: Modifier = Modifier,
    onDriverClick: (DriverItem) -> Unit,
) {
    LazyColumn(modifier = modifier) {
        items(drivers, key = { it.id }) { driverItem ->
            DriverListItem(
                modifier = Modifier.fillMaxWidth(),
                driverItem = driverItem,
                onClick = { onDriverClick.invoke(driverItem) }
            )
            Divider()
        }
    }
}

/**
 * A list item for showing an individual driver
 */
@Composable
fun DriverListItem(
    driverItem: DriverItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(listItemPadding),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        ProfileImage(
            modifier = Modifier.size(48.dp),
            color =  Color(android.graphics.Color.parseColor(driverItem.hexColor)),
        )

        Text(
            text = driverItem.name,
            style = MaterialTheme.typography.body1,
        )
    }
}

/**
 * A profile image with a random background color
 */
@Composable
private fun ProfileImage(color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.height(48.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_person_24),
            contentDescription = null,
            colorFilter = ColorFilter.tint(Color.White.copy(alpha = 0.5f))
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DriverListPreview() {
    DriverList(
        drivers = listOf(
            DriverItem(1, "Andy Rubin", "#ff00ff"),
            DriverItem(2, "Rich Miner", "#ff00ff"),
            DriverItem(3, "Nathan Krebs", "#ff00ff"),
        ),
        onDriverClick = {},
    )
}
