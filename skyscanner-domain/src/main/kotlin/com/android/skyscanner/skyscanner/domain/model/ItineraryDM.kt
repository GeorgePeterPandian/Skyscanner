package com.android.skyscanner.skyscanner.domain.model

data class ItineraryDM(
    val itineraryID: String,

    val legs: List<String>,

    val price: String,

    val agent: String,

    val agentRating: Double,
)