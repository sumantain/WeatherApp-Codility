package com.sbw.weatherapp.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sbw.weatherapp.R
import com.sbw.weatherapp.presentation.state.WeatherState

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.weatherDataForDay?.get(0)?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
//                .padding(horizontal = with(LocalDensity.current) { LocalContext.current.resources.getDimension(
//                    R.dimen.my16dp).toDp()})
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.txt_today),
//                fontSize = with(LocalDensity.current) { LocalContext.current.resources.getDimension(R.dimen.my20sp).toSp()},
                fontSize = 20.sp,
                color = Color.Red
            )
//            Spacer(modifier = Modifier.height(with(LocalDensity.current) { LocalContext.current.resources.getDimension(R.dimen.my16dp).toDp()}))
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(content = {
                items(data) { weatherData ->
                    HourlyDisplay(
                        weatherData = weatherData,
                        modifier = Modifier
//                            .height(with(LocalDensity.current) { LocalContext.current.resources.getDimension(R.dimen.my100dp).toDp()})
//                            .padding(horizontal = with(LocalDensity.current) { LocalContext.current.resources.getDimension(R.dimen.my16dp).toDp()})
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
//
                    )
                }
            })
        }
    }
}