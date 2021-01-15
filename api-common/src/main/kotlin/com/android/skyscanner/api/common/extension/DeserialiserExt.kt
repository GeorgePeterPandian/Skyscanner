package com.android.skyscanner.api.common.extension

import com.squareup.moshi.JsonReader
import org.json.JSONObject

fun <EntityType> JsonReader.deserializeToSet(
    itemDeserializer: (JSONObject?) -> EntityType?
): Set<EntityType> = deserialize(itemDeserializer).toSet()

fun <EntityType> JsonReader.deserialize(
    itemDeserializer: (JSONObject?) -> EntityType?
): List<EntityType> = getJSONObject().fromJson(itemDeserializer)

private fun <EntityType> JSONObject.fromJson(
    itemDeserializer: (JSONObject?) -> EntityType?
): List<EntityType> {
    itemDeserializer(this)?.let { entity -> return listOf(entity) }
    return emptyList()
}