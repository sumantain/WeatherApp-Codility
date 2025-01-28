package com.sbw.weatherapp.presentation

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sbw.weatherapp.R
import com.sbw.weatherapp.presentation.screens.WeatherCard
import com.sbw.weatherapp.presentation.screens.WeatherForecast
import com.sbw.weatherapp.presentation.ui.theme.WeatherAppTheme
import com.sbw.weatherapp.presentation.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: WeatherViewModel by viewModels<WeatherViewModel>()
    lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        permissionLauncher= registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){ permission ->
            if (permission[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
                permission[Manifest.permission.ACCESS_COARSE_LOCATION] == true) {
                viewModel.loadWeatherInfo()
            } else {
                // Check if rationale should be shown
                if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION) ||
                    shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)) {
                    initiatesPermissionRequest()

                } else {
                    // User has denied permissions and selected "Don't ask again"
                    // Handle this case gracefully (e.g., disable location-based features)
                    Toast.makeText(this,
                        getString(R.string.location_permission_is_permanently_denied_you_can_enable_it_in_the_app_settings), Toast.LENGTH_LONG).show()
                }
            }
        }

        //This method initiates the permission request
        initiatesPermissionRequest()

        setContent {
            viewModel.state.let { loadState ->
                WeatherAppTheme {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.LightGray)
                        ) {
                            WeatherCard(
                                state = loadState,
                            )


//                            Spacer(modifier = Modifier.height(with(LocalDensity.current) {resources.getDimension(R.dimen.my16dp).toDp()}))
                            Spacer(modifier = Modifier.height(16.dp))

                            WeatherForecast(state = loadState)

                        }

                        if(loadState.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }

                        loadState.error?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    }
                }
            }
        }
    }

    private fun initiatesPermissionRequest(){
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))
    }
}

