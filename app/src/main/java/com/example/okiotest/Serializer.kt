package com.example.okiotest

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule


/**
 * Created by artman on 06.08.2022.
 */
class Serializer {
    companion object {
        private val module = SerializersModule {

        }

        val json = Json {
            serializersModule = module
            encodeDefaults = true
            isLenient = true
            ignoreUnknownKeys = true
            explicitNulls = false
        }
    }
}