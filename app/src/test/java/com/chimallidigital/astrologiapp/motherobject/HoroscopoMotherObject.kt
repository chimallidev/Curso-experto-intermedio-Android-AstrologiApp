package com.chimallidigital.astrologiapp.motherobject

import com.chimallidigital.astrologiapp.data.network.response.PredictionResponse
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo

object HoroscopoMotherObject {
    val anyResponse= PredictionResponse("date", "prediction", "taurus")

    val horoscopoInfoList: List<HoroscopoInfo> = listOf(
        HoroscopoInfo.Aries,
        HoroscopoInfo.Taurus,
        HoroscopoInfo.Gemini,
        HoroscopoInfo.Cancer,
        HoroscopoInfo.Leo,
        HoroscopoInfo.Virgo,
        HoroscopoInfo.Libra,
        HoroscopoInfo.Scorpio,
        HoroscopoInfo.Sagittarius,
        HoroscopoInfo.Capricorn,
        HoroscopoInfo.Aquarius,
        HoroscopoInfo.Pisces
    )
}