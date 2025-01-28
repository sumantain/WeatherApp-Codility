package com.sbw.weather.domain.model


data class WeatherInfo(
    val weatherDataForDay: Map<Int, List<WeatherData>>,
    val weatherDataNow: WeatherData?
)
