package com.nathankrebs.wastewizard.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.model.RouteItem
import com.nathankrebs.wastewizard.repository.DriverRouteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DriverRouteViewModel(
    private val repository: DriverRouteRepository,
) : ViewModel() {

    /**
     * Internal state value to be updated as needed
     */
    private val _uiState = MutableStateFlow(UiState.INITIAL)

    /**
     * Publisher of [UiState] items
     */
    val uiState: StateFlow<UiState> = _uiState

    /**
     * Get a list of routes for a driver by their ID
     */
    fun getRoutes(driverItem: DriverItem) {
        viewModelScope.launch {
            // try to get a route specific to this driver
            withContext(Dispatchers.IO) {
                val routeForDriver = repository.getRouteWithId(driverItem.id)
                if (routeForDriver != null) {
                    _uiState.update { currentState ->
                        currentState.copy(
                            status = UiStatus.Data,
                            currentDriver = driverItem,
                            routes = listOf(routeForDriver),
                        )
                    }
                    return@withContext
                }

                // if the driver doesn't have a route specifically for them, we evaluate what kind of
                // route they should get
                val routes = when {
                    driverItem.id % 2 == 0 -> repository.getAllResidentialRoutes()
                    driverItem.id % 5 == 0 -> repository.getAllCommercialRoutes()
                    else -> repository.getAllIndustrialRoutes()
                }
                _uiState.update { currentState ->
                    currentState.copy(
                        status = UiStatus.Data,
                        currentDriver = driverItem,
                        routes = routes,
                    )
                }
            }
        }
    }

    data class UiState(
        val status: UiStatus,
        val currentDriver: DriverItem?,
        val routes: List<RouteItem>,
    ) {
        companion object {
            val INITIAL = UiState(
                routes = emptyList(),
                currentDriver = null,
                status = UiStatus.Loading,
            )
        }
    }

    /**
     * Represents the current status of the UI within [UiState]
     */
    enum class UiStatus {
        Loading,
        Data,
    }
}
