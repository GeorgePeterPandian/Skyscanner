package com.android.skyscanner.skyscanner.data

import com.android.skyscanner.skyscanner.data.model.FlightsAM
import com.android.skyscanner.skyscanner.data.model.ItineraryAM
import com.android.skyscanner.skyscanner.data.model.LegsAM
import com.mifli.api.common.utils.loadJsonAsText


internal object APIMock {

    private val itineraries = listOf(
        ItineraryAM(
            itineraryID = "it_1",
            legs = listOf("leg_1", "leg_2"),
            price = "£35",
            agent = "Wizzair.com",
            agentRating = 9.1
        )
    )

    private val legs = listOf(
        LegsAM(
            legId = "leg_1",
            departureAirport = "BUD",
            arrivalAirport = "LTN",
            departureTime = "2020-10-31T15:35",
            arrivalTime = "2020-10-31T17:00",
            stops = 0,
            airlineName = "Wizz Air",
            airlineId = "WZ",
            durationMins = "145"
        ),
        LegsAM(
            legId = "leg_2",
            departureAirport = "BUD",
            arrivalAirport = "FRA",
            departureTime = "2020-10-31T12:05",
            arrivalTime = "2020-10-31T17:00",
            stops = 1,
            airlineName = "easyJet",
            airlineId = "EZ",
            durationMins = "190"
        )
    )

    private val validFlightsAM = FlightsAM(
        itineraries = itineraries,
        legs = legs
    )


    val expectedEmptyResponse = FlightsAM(itineraries = null, legs = null)
    val expectedValidResponse = validFlightsAM
    val unexpectedResponse = validFlightsAM.copy(itineraries = null)


    val actual_valid_json = javaClass.loadJsonAsText("/flights_list.json")
    val actual_empty_json = javaClass.loadJsonAsText("/flights_list_empty.json")
}