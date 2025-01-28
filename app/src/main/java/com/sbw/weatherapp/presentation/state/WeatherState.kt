package com.sbw.weatherapp.presentation.state

import com.sbw.weather.domain.model.WeatherInfo


data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
