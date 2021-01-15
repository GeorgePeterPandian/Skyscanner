package com.android.skyscanner.skyscanner.data.remote

import com.android.skyscanner.skyscanner.data.FlightsDS.Remote
import com.android.skyscanner.skyscanner.data.model.FlightsAM
import com.android.skyscanner.skyscanner.data.model.toDM
import com.android.skyscanner.skyscanner.domain.model.FlightsDM
import com.android.skyscanner.skyscanner.domain.model.ItineraryDM
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FlightsApiDS @Inject constructor(private val service: FlightsApiService) : Remote {

    override fun loadFlights(): Single<FlightsDM> =
        service.loadFlights().map { it.toDM() }
}