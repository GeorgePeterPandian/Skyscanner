package com.android.skyscanner.skyscanner.data.model

import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.ITINERARY_ARRAY
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.LEGS_ARRAY
import com.squareup.moshi.Json

data class FlightsAM (

    @field:Json(name = ITINERARY_ARRAY)
    val itineraries: List<ItineraryAM>?,

    @field:Json(name = LEGS_ARRAY)
    val legs: List<LegsAM>?
)