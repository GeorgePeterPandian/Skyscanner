package com.android.skyscanner.uk

import com.android.skyscanner.skyscanner.domain.model.LegsDM
import com.android.skyscanner.uk.flights.model.*
import com.android.skyscanner.uk.flights.model.getStopsDetails
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class MappersTest {

    private lateinit var legs: List<LegsDM>

    @Before
    fun setUp() {
        legs = listOf(
            LegsDM(
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
            LegsDM(
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
    }

    @Test
    fun testLegFormattedTime_valid() {
        assertEquals("15:35-17:00", getLegFormattedTime(legs.first().legId, legs))
    }

    @Test
    fun testLegFormattedTime_invalid() {
        assertNotEquals("15:35-17:10", getLegFormattedTime(legs.first().legId, legs))
    }

    @Test
    fun testLegAirlineId_valid() {
        assertEquals("WZ", getLegAirlineId(legs.first().legId, legs))
    }

    @Test
    fun testLegAirlineId_invalid() {
        assertNotEquals("EZ", getLegAirlineId(legs.first().legId, legs))
    }

    @Test
    fun testLegProviderDetails_valid() {
        assertEquals("BUD-LTN,Wizz Air", getLegProviderDetails(legs.first().legId, legs))
    }

    @Test
    fun testLegProviderDetails_invalid() {
        assertNotEquals("BUD-LTN,easyJet", getLegProviderDetails(legs.first().legId, legs))
    }

    @Test
    fun testStopsDetails_valid() {
        assertEquals("Direct", getStopsDetails(legs.first().legId, legs))
    }

    @Test
    fun testStopsDetails_invalid() {
        assertNotEquals("1 Stop", getStopsDetails(legs.first().legId, legs))
    }

    @Test
    fun testLegDuration_valid() {
        assertEquals("02:25m", getLegDuration(legs.first().legId, legs))
    }

    @Test
    fun testLegDuration_invalid() {
        assertNotEquals("01:25m", getLegDuration(legs.first().legId, legs))
    }

}