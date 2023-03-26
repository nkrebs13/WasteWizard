package com.nathankrebs.wastewizard.network

import com.nathankrebs.wastewizard.network.model.DriverAndRouteApiItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class DriverRemoteDataSourceImpl(private val httpClient: HttpClient): DriverRemoteDataSource {
    override suspend fun getDriverAndRoute(): DriverAndRouteApiItem {
        // Cannot simply do httpClient.get(BASE_URL).body() because the server response is
        // "plain/text" and not "application/json" so we decode manually
        val result: String = httpClient.get(BASE_URL).body()
        return NetworkingSingleton.AppJson.decodeFromString(
            DriverAndRouteApiItem.serializer(),
            result
        )
    }

    companion object {
        private const val BASE_URL = "https://d49c3a78-a4f2-437d-bf72-569334dea17c.mock.pstmn.io/data"
    }
}
