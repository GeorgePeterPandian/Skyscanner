package com.android.skyscanner.skyscanner.domain.model

data class FlightsDM(
    val itineraries: List<ItineraryDM>,

    val legs: List<LegsDM>
)