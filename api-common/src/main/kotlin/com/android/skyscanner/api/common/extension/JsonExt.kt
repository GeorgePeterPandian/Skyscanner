package com.android.skyscanner.api.common.extension

import com.android.skyscanner.api.common.definitions.API.JSON_FIELD_ITINERARIES
import com.android.skyscanner.api.common.definitions.API.JSON_FIELD_LEGS
import com.squareup.moshi.JsonReader
import org.json.JSONArray
import org.json.JSONObject

fun JsonReader.getJSONObject(): JSONObject = JSONObject(gson.toJson(readJsonValue()))

/*fun JSONObject.getItineraryArray(): JSONArray? = optJSONArray(JSON_FIELD_ITINERARIES)

fun JSONObject.getItineraryObject(): JSONObject? = optJSONObject(JSON_FIELD_ITINERARIES)

fun JSONObject.getLegsArray(): JSONArray? = optJSONArray(JSON_FIELD_LEGS)

fun JSONObject.getLegObject(): JSONObject? = optJSONObject(JSON_FIELD_LEGS)*/

fun <T> JSONObject.createEntity(type: Class<T>): T? =
    moshi.adapter(type).fromJson(this@createEntity.toString())