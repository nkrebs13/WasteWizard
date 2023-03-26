package com.nathankrebs.wastewizard

import androidx.lifecycle.ViewModel
import com.nathankrebs.wastewizard.db.DriverLocalDataSource
import com.nathankrebs.wastewizard.db.DriverLocalDataSourceImpl
import com.nathankrebs.wastewizard.db.DriverRouteDatabase
import com.nathankrebs.wastewizard.network.DriverRemoteDataSource
import com.nathankrebs.wastewizard.network.DriverRemoteDataSourceImpl
import com.nathankrebs.wastewizard.network.NetworkingSingleton
import com.nathankrebs.wastewizard.ui.DriverListViewModel
import io.ktor.client.HttpClient
import org.koin.android.ext.koin.androidContext
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

    single<ViewModel> {
        DriverListViewModel(
            repository = get(),
        )
    }
}
