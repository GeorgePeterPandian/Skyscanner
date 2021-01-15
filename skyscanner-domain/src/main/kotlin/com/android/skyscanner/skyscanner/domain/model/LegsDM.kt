package com.android.skyscanner.skyscanner.domain.model

data class LegsDM(
    val legId: String,

    val departureAirport: String,

    val arrivalAirport: String,

    val departureTime: String,

    val arrivalTime: String,

    val stops: Int,

    val airlineName: String,

    val airlineId: String,

    val durationMins: String
)