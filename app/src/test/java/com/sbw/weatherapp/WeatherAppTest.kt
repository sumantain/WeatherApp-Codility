package com.sbw.weatherapp

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

import io.mockk.verify

import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class WeatherAppTest {

    private lateinit var weatherApp: WeatherApp


    @Test
    fun testOnCreate() {
        weatherApp.onCreate()

        Assert.assertNotNull(weatherApp.assets)
        verify { weatherApp.applicationContext }
    }
}