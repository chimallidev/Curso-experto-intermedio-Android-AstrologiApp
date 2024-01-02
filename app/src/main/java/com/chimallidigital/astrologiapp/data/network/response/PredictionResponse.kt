package com.chimallidigital.astrologiapp.data.network.response
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.*
import com.chimallidigital.astrologiapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse (
    @SerializedName("date") val date: String,
    @SerializedName("horoscope") val horoscope: String,
    @SerializedName("sign") val sign: String
) {
    fun toDomain(): PredictionModel {
        return PredictionModel(
            horoscope = horoscope,
            sign = sign
        )
    }
}