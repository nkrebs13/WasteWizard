package com.nathankrebs.wastewizard.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.nathankrebs.wastewizard.ui.DriverListViewModel
import org.koin.androidx.compose.getViewModel


@Composable
fun DriverListScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel: DriverListViewModel = getViewModel()
    val uiState = viewModel.uiState.collectAsState()
    DriverList(
        modifier = modifier,
        drivers = uiState.value.drivers,
        onDriverClick = { driver -> viewModel.onDriverClick(driver) },
    )
}
