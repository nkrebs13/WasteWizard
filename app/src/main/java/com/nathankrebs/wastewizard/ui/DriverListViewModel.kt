package com.nathankrebs.wastewizard.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nathankrebs.wastewizard.model.DriverItem
import com.nathankrebs.wastewizard.repository.DriverRouteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DriverListViewModel(
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

    init {
        viewModelScope.launch {
            try {
                val drivers = repository.getAllDrivers()
                _uiState.update { currentState ->
                    currentState.copy(drivers = drivers, status = UiStatus.Data)
                }
            } catch (e: Exception) {
                _uiState.update { currentState ->
                    currentState.copy(status = UiStatus.Error)
                }
            }
        }
    }

    data class UiState(
        val drivers: List<DriverItem>,
        val status: UiStatus,
    ) {
        companion object {
            val INITIAL = UiState(
                drivers = emptyList(),
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
        Error,
    }

    companion object {
        private const val TAG = "DriverListVM"
    }
}
