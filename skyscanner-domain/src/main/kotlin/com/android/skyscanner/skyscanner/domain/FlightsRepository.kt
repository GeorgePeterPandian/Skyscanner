package com.android.skyscanner.skyscanner.domain

import com.android.skyscanner.skyscanner.domain.model.FlightsDM
import com.android.skyscanner.skyscanner.domain.model.ItineraryDM
import io.reactivex.rxjava3.core.Single

interface FlightsRepository {

    fun loadFlights(): Single<FlightsDM>
}