package com.sbw.weatherapp.presentation

import android.Manifest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import io.mockk.verify

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testPermissionRequest() {
        // Mock the permission result
        val mockPermissionResult = mutableMapOf(
            Manifest.permission.ACCESS_FINE_LOCATION to true,
            Manifest.permission.ACCESS_COARSE_LOCATION to true
        )

        // Grant permissions
        activityScenarioRule.scenario.onActivity {
            it.permissionLauncher.launch(mockPermissionResult.keys.toTypedArray())
        }

        // Verify that loadWeatherInfo() is called
        verify(exactly = 1) { activityScenarioRule.scenario.onActivity { it.viewModel.loadWeatherInfo() } }
    }

}

