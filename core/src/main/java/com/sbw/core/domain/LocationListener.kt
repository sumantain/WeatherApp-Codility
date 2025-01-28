package com.sbw.core.domain

import android.location.Location

interface LocationListener {

    suspend fun getCurrentLocation(): Location?
}