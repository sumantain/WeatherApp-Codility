package com.sbw.weather.domain.repository

import com.sbw.weather.domain.model.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherInfo(latitude: Double, longitude: Double): Result<WeatherInfo>
}