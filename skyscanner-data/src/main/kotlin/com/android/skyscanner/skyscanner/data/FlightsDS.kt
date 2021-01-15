package com.android.skyscanner.skyscanner.data

import com.android.skyscanner.skyscanner.domain.model.FlightsDM
import io.reactivex.rxjava3.core.Single

interface FlightsDS {

    interface Remote {

        fun loadFlights(): Single<FlightsDM>
    }
}