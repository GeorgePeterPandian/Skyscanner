package com.android.skyscanner.skyscanner.data

import com.android.skyscanner.skyscanner.data.FlightsDS.Remote
import com.android.skyscanner.skyscanner.domain.FlightsRepository
import javax.inject.Inject

class FlightsRepositoryImpl @Inject constructor(private val remoteDS: Remote) : FlightsRepository {

    override fun loadFlights() = remoteDS.loadFlights()
}