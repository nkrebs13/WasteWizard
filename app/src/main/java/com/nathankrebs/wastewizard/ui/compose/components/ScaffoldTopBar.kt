package com.nathankrebs.wastewizard.ui.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Composable for the "top bar" in a Scaffold
 *
 * @param topBarEndContent Optional composable that will be placed at the end (ie right) of the
 * top bar
 */
@Composable
fun ScaffoldTopBar(
    modifier: Modifier = Modifier,
    topBarText: String,
    topBarEndContent: (@Composable () -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .background(MaterialTheme.colors.primary)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = topBarText,
            style = MaterialTheme.typography.h5,
        )
        topBarEndContent?.invoke()
    }
}
