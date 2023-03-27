package com.nathankrebs.wastewizard.ui.compose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.nathankrebs.wastewizard.R

@Composable
fun DriverListHeader(
    onSortClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    ScaffoldTopBar(
        modifier = modifier,
        topBarText = stringResource(R.string.driver_list_screen_header),
        topBarEndContent = {
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .clickable(onClick = onSortClick),
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_sort_24),
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = MaterialTheme.typography.h4.color)
            )
        }
    )
}