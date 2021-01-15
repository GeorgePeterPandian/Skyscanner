package com.android.skyscanner.skyscanner.data.model

import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.AGENT
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.AGENT_RATING
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.ITINERARY_ID
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.LEGS
import com.android.skyscanner.skyscanner.data.definitions.APIDefinitions.PRICE
import com.squareup.moshi.Json

data class ItineraryAM(

    @field:Json(name = ITINERARY_ID)
    val itineraryID: String?,

    @field:Json(name = LEGS)
    val legs: List<String>?,

    @field:Json(name = PRICE)
    val price: String?,

    @field:Json(name = AGENT)
    val agent: String?,

    @field:Json(name = AGENT_RATING)
    val agentRating: Double?,

)