package com.nathankrebs.wastewizard.ui.compose.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.ui.DriverRouteViewModel
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
    RouteList(
        modifier = modifier,
        routes = uiState.value.routes,
    )
}
