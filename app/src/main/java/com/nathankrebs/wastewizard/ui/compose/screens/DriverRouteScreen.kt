package com.nathankrebs.wastewizard.ui.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.ui.DriverListViewModel
import com.nathankrebs.wastewizard.ui.DriverRouteViewModel
import com.nathankrebs.wastewizard.ui.compose.components.LoadingDialog
import com.nathankrebs.wastewizard.ui.compose.components.RouteList
import org.koin.androidx.compose.getViewModel

@Composable
fun DriverRouteScreen(
    driverItem: DriverItem,
    modifier: Modifier = Modifier,
) {
    val viewModel: DriverRouteViewModel = getViewModel()
    val uiState = viewModel.uiState.collectAsState()
    LaunchedEffect(driverItem) {
        viewModel.getRoutes(driverItem)
    }
    Box(modifier = modifier) {
        if (uiState.value.status == DriverRouteViewModel.UiStatus.Loading) {
            LoadingDialog()
        }

        RouteList(
            modifier = modifier,
            routes = uiState.value.routes,
        )
    }
}
