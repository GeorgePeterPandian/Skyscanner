package com.android.skyscanner.uk.flights.model

import androidx.annotation.VisibleForTesting
import com.android.skyscanner.skyscanner.domain.model.FlightsDM
import com.android.skyscanner.skyscanner.domain.model.LegsDM
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

internal fun FlightsDM.toUIM(): List<FlightsUIM> {
    val flights = mutableListOf<FlightsUIM>()

    this.itineraries.forEach { itinerary ->
        flights.add(
            FlightsUIM(
                id = itinerary.itineraryID,
                leg1AirlineId = getLegAirlineId(itinerary.legs.firstOrNull(), this.legs),
                leg2AirlineId = getLegAirlineId(itinerary.legs.lastOrNull(), this.legs),
                leg1TimeDetails = getLegFormattedTime(itinerary.legs.firstOrNull(), this.legs),
                leg2TimeDetails = getLegFormattedTime(itinerary.legs.lastOrNull(), this.legs),
                leg1AirportAndProviderDetails = getLegProviderDetails(
                    itinerary.legs.firstOrNull(),
                    this.legs
                ),
                leg2AirportAndProviderDetails = getLegProviderDetails(
                    itinerary.legs.lastOrNull(),
                    this.legs
                ),
                leg1Stops = getStopsDetails(itinerary.legs.firstOrNull(), this.legs),
                leg2Stops = getStopsDetails(itinerary.legs.lastOrNull(), this.legs),
                leg1Duration = getLegDuration(itinerary.legs.firstOrNull(), this.legs),
                leg2Duration = getLegDuration(itinerary.legs.lastOrNull(), this.legs),
                price = itinerary.price,
                provider = "via ".plus(itinerary.agent)
            )
        )
    }

    return flights.toList()
}

internal fun getLegFormattedTime(leg: String?, legs: List<LegsDM>): String = when {
    leg.isNullOrEmpty() -> ""
    else -> {
        when (val legDetails = legs.firstOrNull { it.legId == leg }) {
            null -> ""
            else -> LocalDateTime
                .parse(legDetails.departureTime).toLocalTime().toString().plus("-").plus(
                    LocalDateTime
                        .parse(
                            legDetails.arrivalTime
                        ).toLocalTime()
                )
        }
    }
}

internal fun getLegAirlineId(leg: String?, legs: List<LegsDM>): String = when {
    leg.isNullOrEmpty() -> ""
    else -> {
        when (val legDetails = legs.firstOrNull { it.legId == leg }) {
            null -> ""
            else -> legDetails.airlineId
        }
    }
}

internal fun getLegProviderDetails(leg: String?, legs: List<LegsDM>): String = when {
    leg.isNullOrEmpty() -> ""
    else -> {
        when (val legDetails = legs.firstOrNull { it.legId == leg }) {
            null -> ""
            else -> {
                legDetails.departureAirport.plus("-").plus(legDetails.arrivalAirport)
                    .plus(",").plus(legDetails.airlineName)
            }
        }
    }
}

internal fun getStopsDetails(leg: String?, legs: List<LegsDM>): String = when {
    leg.isNullOrEmpty() -> ""
    else -> {
        when (val legDetails = legs.firstOrNull { it.legId == leg }) {
            null -> ""
            else -> {
                when (legDetails.stops) {
                    0 -> "Direct"
                    1 -> "1 Stop"
                    else -> legDetails.stops.toString().plus(" Stops")
                }
            }
        }
    }
}

internal fun getLegDuration(leg: String?, legs: List<LegsDM>): String = when {
    leg.isNullOrEmpty() -> ""
    else -> {
        when (val legDetails = legs.firstOrNull { it.legId == leg }) {
            null -> ""
            else -> LocalTime.MIN.plus(
                Duration.ofMinutes(legDetails.durationMins.toLong())
            ).toString().plus("m")
        }
    }
}
