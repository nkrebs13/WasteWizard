package com.nathankrebs.wastewizard.ui.compose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.nathankrebs.wastewizard.R
import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.ui.DriverRouteViewModel
import com.nathankrebs.wastewizard.ui.compose.components.LoadingDialog
import com.nathankrebs.wastewizard.ui.compose.components.RouteList
import com.nathankrebs.wastewizard.ui.compose.components.ScaffoldTopBar
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
    Scaffold(
        modifier = modifier,
        topBar = {
            ScaffoldTopBar(
                modifier = Modifier.fillMaxWidth(),
                topBarText = when (val driverName = uiState.value.currentDriver?.name) {
                    null -> stringResource(R.string.route_list_screen_header_default)
                    else -> stringResource(R.string.route_list_screen_header, driverName)
                }
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                if (uiState.value.status == DriverRouteViewModel.UiStatus.Loading) {
                    LoadingDialog()
                }

                RouteList(
                    modifier = modifier,
                    routes = uiState.value.routes,
                )
            }
        }
    )
}
