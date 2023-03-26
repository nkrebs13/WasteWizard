package com.nathankrebs.wastewizard

import com.nathankrebs.wastewizard.db.DriverLocalDataSource
import com.nathankrebs.wastewizard.db.DriverLocalDataSourceImpl
import com.nathankrebs.wastewizard.db.DriverRouteDatabase
import com.nathankrebs.wastewizard.network.DriverRemoteDataSource
import com.nathankrebs.wastewizard.network.DriverRemoteDataSourceImpl
import com.nathankrebs.wastewizard.network.NetworkingSingleton
import com.nathankrebs.wastewizard.repository.DriverRouteRepository
import com.nathankrebs.wastewizard.repository.DriverRouteRepositoryImpl
import com.nathankrebs.wastewizard.ui.DriverListViewModel
import com.nathankrebs.wastewizard.ui.DriverRouteViewModel
import io.ktor.client.HttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModuleDi = module {
    single<HttpClient> {
        NetworkingSingleton.AppHttpClient
    }

    single<DriverRemoteDataSource> {
        DriverRemoteDataSourceImpl(
            httpClient = get()
        )
    }

    single<DriverLocalDataSource> {
        DriverLocalDataSourceImpl(
            database = DriverRouteDatabase.getDatabase(androidContext())
        )
    }

    single<DriverRouteRepository> {
        DriverRouteRepositoryImpl(
            driverRemoteDataSource = get(),
            driverLocalDataSource = get(),
        )
    }

    viewModel<DriverListViewModel> {
        DriverListViewModel(
            repository = get(),
        )
    }

    viewModel<DriverRouteViewModel> {
        DriverRouteViewModel(
            repository = get(),
        )
    }
}
