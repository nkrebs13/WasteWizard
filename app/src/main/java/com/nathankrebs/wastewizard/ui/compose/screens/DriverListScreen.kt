package com.nathankrebs.wastewizard.ui.compose.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.ui.DriverListViewModel
import com.nathankrebs.wastewizard.ui.compose.components.DriverList
import org.koin.androidx.compose.getViewModel

@Composable
fun DriverListScreen(
    modifier: Modifier = Modifier,
    onDriverClick: (DriverItem) -> Unit,
) {
    val viewModel: DriverListViewModel = getViewModel()
    val uiState = viewModel.uiState.collectAsState()
    DriverList(
        modifier = modifier,
        drivers = uiState.value.drivers,
        onDriverClick = { driver -> onDriverClick(driver) },
    )
}
