package com.android.skyscanner.skyscanner.data

import com.android.skyscanner.skyscanner.data.APIMock.actual_empty_json
import com.android.skyscanner.skyscanner.data.APIMock.actual_valid_json
import com.android.skyscanner.skyscanner.data.APIMock.expectedEmptyResponse
import com.android.skyscanner.skyscanner.data.APIMock.expectedValidResponse
import com.android.skyscanner.skyscanner.data.APIMock.unexpectedResponse
import com.android.skyscanner.skyscanner.data.model.FlightsAM
import com.android.skyscanner.skyscanner.data.remote.FlightJsonAdapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import org.junit.Assert.*
import org.junit.Test

class FlightsJsonAdapterTests {

    private val adapter: JsonAdapter<FlightsAM> =
        Moshi
            .Builder()
            .add(FlightJsonAdapter())
            .build()
            .adapter(FlightsAM::class.java)

    @Test
    fun `from JSON empty response`() {
        with(adapter.fromJson(actual_empty_json)) {
            assertNotNull(this)
            assertEquals(expectedEmptyResponse, this)
        }
    }

    @Test
    fun `from JSON valid data response`() {
        with(adapter.fromJson(actual_valid_json)) {
            assertNotNull(this)
            assertEquals(expectedValidResponse, this)
        }
    }

    @Test
    fun `from JSON invalid data response`() {
        with(adapter.fromJson(actual_valid_json)) {
            assertNotNull(this)
            assertEquals(expectedValidResponse, this)
            assertNotEquals(unexpectedResponse, this)
        }
    }
}