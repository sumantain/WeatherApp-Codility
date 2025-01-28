package com.sbw.weatherapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sbw.weatherapp.R
import com.sbw.weather.domain.model.WeatherData
import com.sbw.weatherapp.presentation.viewmodel.WeatherViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HourlyDisplay(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Red
) {
    val viewModel: WeatherViewModel = viewModel()
    val formattedTime = remember(weatherData) {
        viewModel.formatTime(weatherData.time)
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = formattedTime,
            color = textColor
        )
        Image(
            painter = painterResource(id = weatherData.weatherType.icon),
            contentDescription = null,
//            modifier = Modifier.width(with(LocalDensity.current) { LocalContext.current.resources.getDimension(
//                R.dimen.my40dp).toDp()})
                    modifier = Modifier.width(40.dp)
        )
        Text(
            text = stringResource(R.string.c, weatherData.temperatureCelsius),
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }
}