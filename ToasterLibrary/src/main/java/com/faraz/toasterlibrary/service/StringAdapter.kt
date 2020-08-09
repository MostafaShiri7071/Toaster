package com.faraz.toasterlibrary.service

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Modifier
import java.lang.reflect.Type


class StringAdapter : JsonDeserializer<Any?> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext?
    ): Any? {
        try {
            val content = json.asString
            if (content == "0") if (typeOfT === String::class.java) return null
            if (content == "NODATA" || content == "[]" || content == "") return null
        } catch (ignored: IllegalStateException) {
        } catch (ignored: UnsupportedOperationException) {
        }
        return GsonBuilder().excludeFieldsWithModifiers(
            Modifier.FINAL,
            Modifier.TRANSIENT,
            Modifier.STATIC
        ) //                .registerTypeAdapter(ParentProfile.class, new ParentProfileInstanceCreator())
            .create().fromJson<Any>(json, typeOfT)
    }
}