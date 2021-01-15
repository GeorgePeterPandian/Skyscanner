package com.android.skyscanner.skyscanner.data.model

import com.android.skyscanner.core.extensions.orZero
import com.android.skyscanner.skyscanner.domain.model.FlightsDM
import com.android.skyscanner.skyscanner.domain.model.ItineraryDM
import com.android.skyscanner.skyscanner.domain.model.LegsDM

internal fun FlightsAM?.toDM(): FlightsDM = FlightsDM(
    itineraries = this?.itineraries?.map { it.toItineraryDM() }.orEmpty(),
    legs = this?.legs?.map { it.toLegsDM() }.orEmpty(),
)

private fun ItineraryAM.toItineraryDM() =
    ItineraryDM(
        itineraryID = itineraryID.orEmpty(),
        legs = legs.orEmpty(),
        price = price.orEmpty(),
        agent = agent.orEmpty(),
        agentRating = agentRating.orZero()
    )

private fun LegsAM.toLegsDM() =
    LegsDM(
        legId = legId.orEmpty(),
        departureAirport = departureAirport.orEmpty(),
        arrivalAirport = arrivalAirport.orEmpty(),
        departureTime = departureTime.orEmpty(),
        arrivalTime = arrivalTime.orEmpty(),
        stops = stops.orZero(),
        airlineName = airlineName.orEmpty(),
        airlineId = airlineId.orEmpty(),
        durationMins = durationMins.orEmpty()
    )