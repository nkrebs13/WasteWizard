package com.nathankrebs.wastewizard.ui.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.ui.DriverListViewModel
import com.nathankrebs.wastewizard.ui.compose.components.DriverList
import com.nathankrebs.wastewizard.ui.compose.components.DriverListHeader
import com.nathankrebs.wastewizard.ui.compose.components.ErrorUi
import com.nathankrebs.wastewizard.ui.compose.components.LoadingDialog
import org.koin.androidx.compose.getViewModel

@Composable
fun DriverListScreen(
    modifier: Modifier = Modifier,
    onDriverClick: (DriverItem) -> Unit,
) {
    val viewModel: DriverListViewModel = getViewModel()
    val uiState = viewModel.uiState.collectAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            DriverListHeader(
                modifier = Modifier.fillMaxWidth(),
                onSortClick = { viewModel.sortDriversClick() }
            )
        },
        content = { paddingValues ->
            if (uiState.value.status == DriverListViewModel.UiStatus.Error) {
                ErrorUi(
                    modifier = Modifier.padding(paddingValues).fillMaxSize(),
                    onClickRetry = { viewModel.onRetryDataClick() }
                )
            } else {
                Box(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                ) {
                    if (uiState.value.status == DriverListViewModel.UiStatus.Loading) {
                        LoadingDialog()
                    }

                    DriverList(
                        modifier = Modifier.fillMaxSize(),
                        drivers = uiState.value.drivers,
                        onDriverClick = { driver -> onDriverClick(driver) },
                    )
                }
            }
        }
    )
}
