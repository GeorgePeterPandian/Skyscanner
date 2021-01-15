package com.android.skyscanner.skyscanner.data.remote

import androidx.annotation.VisibleForTesting
import com.android.skyscanner.api.common.extension.createEntity
import com.android.skyscanner.api.common.extension.getJSONObject
import com.android.skyscanner.skyscanner.data.model.FlightsAM
import com.squareup.moshi.*
import org.json.JSONObject

internal class FlightJsonAdapter : JsonAdapter<FlightsAM>() {

    @FromJson
    override fun fromJson(jsonReader: JsonReader): FlightsAM? =
        jsonReader.getJSONObject().fromJson()

    @VisibleForTesting
    fun JSONObject?.fromJson(): FlightsAM? =
        this?.createEntity(FlightsAM::class.java)?.copy() ?: throw IllegalArgumentException()

    @ToJson
    override fun toJson(writer: JsonWriter, value: FlightsAM?) {
        throw UnsupportedOperationException()
    }
}