package com.nathankrebs.wastewizard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.nathankrebs.wastewizard.network.DriverRemoteDataSourceImpl
import com.nathankrebs.wastewizard.network.NetworkingSingleton
import com.nathankrebs.wastewizard.ui.theme.WasteWizardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WasteWizardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val textToShow = remember { mutableStateOf("") }
                    LaunchedEffect(Unit) {
                        textToShow.value = DriverRemoteDataSourceImpl(
                            NetworkingSingleton.AppHttpClient
                        ).getDriverAndRoute().toString()
                    }
                    Text(text = textToShow.value)
                }
            }
        }
    }
}
