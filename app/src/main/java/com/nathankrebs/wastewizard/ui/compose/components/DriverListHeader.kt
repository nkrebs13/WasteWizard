package com.nathankrebs.wastewizard.ui.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nathankrebs.wastewizard.R

@Composable
fun DriverListHeader(
    onSortClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(MaterialTheme.colors.primary)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = stringResource(R.string.driver_list_screen_header),
            style = MaterialTheme.typography.h4,
        )
        Image(
            modifier = Modifier.size(24.dp).clickable(onClick = onSortClick),
            imageVector = ImageVector.vectorResource(id = R.drawable.baseline_sort_24),
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = MaterialTheme.typography.h4.color)
        )
    }
}

@Preview
@Composable
private fun DriverListHeaderPreview() {
    DriverListHeader(onSortClick = {})
}