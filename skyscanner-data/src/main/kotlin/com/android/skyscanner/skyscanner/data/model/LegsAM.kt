package com.android.skyscanner.skyscanner.data.model

import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.LEG_AIRLINE_ID
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.LEG_AIRLINE_NAME
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.LEG_ARRIVAL_AIRPORT
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.LEG_ARRIVAL_TIME
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.LEG_DEPARTURE_AIRPORT
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.LEG_DEPARTURE_TIME
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.LEG_DURATION_IN_MINS
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.LEG_ID
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.LEG_STOPS
import com.squareup.moshi.Json

data class LegsAM(

    @field:Json(name = LEG_ID)
    val legId: String?,

    @field:Json(name = LEG_DEPARTURE_AIRPORT)
    val departureAirport: String?,

    @field:Json(name = LEG_ARRIVAL_AIRPORT)
    val arrivalAirport: String?,

    @field:Json(name = LEG_DEPARTURE_TIME)
    val departureTime: String?,

    @field:Json(name = LEG_ARRIVAL_TIME)
    val arrivalTime: String?,

    @field:Json(name = LEG_STOPS)
    val stops: Int?,

    @field:Json(name = LEG_AIRLINE_NAME)
    val airlineName: String?,

    @field:Json(name = LEG_AIRLINE_ID)
    val airlineId: String?,

    @field:Json(name = LEG_DURATION_IN_MINS)
    val durationMins: String?
)