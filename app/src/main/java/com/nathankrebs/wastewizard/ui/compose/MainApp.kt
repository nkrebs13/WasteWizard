package com.nathankrebs.wastewizard.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.network.NetworkingSingleton
import com.nathankrebs.wastewizard.ui.compose.Navigation.navToDriverRoute
import com.nathankrebs.wastewizard.ui.compose.screens.DriverListScreen
import com.nathankrebs.wastewizard.ui.compose.screens.DriverRouteScreen

/**
 * The "main" screen for the application
 */
@Composable
fun MainApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Navigation.NAVROUTE_DRIVER_LIST) {
        driverListGraph(
            modifier = modifier,
            onDriverClick = { driverItem -> navController.navToDriverRoute(driverItem) }
        )
        driverRouteGraph(modifier)
    }
}

/**
 * Defines some navigation-related constants and helper functions
 */
private object Navigation {
    /**
     * Route for [driverListGraph]
     */
    const val NAVROUTE_DRIVER_LIST = "drivers"

    /**
     * Route for [driverRouteGraph].
     *
     * Navigate to this with [navToDriverRoute]
     */
    const val NAVROUTE_DRIVER_ROUTE_LIST = "routes/{driverItem}"

    /**
     * Used to navigate to [driverRouteGraph]
     */
    fun NavController.navToDriverRoute(driverItem: DriverItem) {
        this.navigate("routes/${driverItem.toJsonString()}")
    }
}

private fun NavGraphBuilder.driverListGraph(
    modifier: Modifier,
    onDriverClick: (DriverItem) -> Unit,
) {
    composable(Navigation.NAVROUTE_DRIVER_LIST) {
        DriverListScreen(
            modifier = modifier,
            onDriverClick = onDriverClick,
        )
    }
}

private fun NavGraphBuilder.driverRouteGraph(modifier: Modifier) {
    composable(
        route = Navigation.NAVROUTE_DRIVER_ROUTE_LIST,
        arguments = listOf(navArgument("driverItem") { type = NavType.StringType })
    ) { backStackEntry ->
        val driverItem = backStackEntry.arguments?.getString("driverItem")?.toDriverItem()
            ?: throw IllegalArgumentException("You need to pass in a 'driverItem' argument!")
        DriverRouteScreen(
            modifier = modifier,
            driverItem = driverItem,
        )
    }
}

private fun String.toDriverItem(): DriverItem =
    NetworkingSingleton.AppJson.decodeFromString(DriverItem.serializer(), this)

private fun DriverItem.toJsonString(): String =
    NetworkingSingleton.AppJson.encodeToString(DriverItem.serializer(), this)
