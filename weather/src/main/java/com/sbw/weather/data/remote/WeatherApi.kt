package com.sbw.weather.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    /**
     * Retrieves weather information for the specified latitude and longitude.
     *
     * @param latitude  The latitude coordinate.
     * @param longitude The longitude coordinate.
     * @return A {@link Call} object that represents the asynchronous request for weather data.
     */
    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getWeatherInfo(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double
    ): WeatherDto
}