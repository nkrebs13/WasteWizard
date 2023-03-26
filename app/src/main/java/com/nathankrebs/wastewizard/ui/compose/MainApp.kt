package com.nathankrebs.wastewizard.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.network.NetworkingSingleton

@Composable
fun MainApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "drivers") {
        composable("drivers") {
            DriverListScreen(
                modifier = modifier,
                onDriverClick = { driverItem ->
                    navController.navigate("routes/${driverItem.toJsonString()}")
                }
            )
        }

        composable(
            route = "routes/{driverItem}",
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
}

private fun String.toDriverItem(): DriverItem =
    NetworkingSingleton.AppJson.decodeFromString(DriverItem.serializer(), this)

private fun DriverItem.toJsonString(): String =
    NetworkingSingleton.AppJson.encodeToString(DriverItem.serializer(), this)
