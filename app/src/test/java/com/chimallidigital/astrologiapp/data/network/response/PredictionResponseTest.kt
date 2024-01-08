package com.chimallidigital.astrologiapp.data.network.response

import com.chimallidigital.astrologiapp.motherobject.HoroscopoMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test

class PredictionResponseTest {
    @Test
    fun `toDomain should return a correct PredictionModel`() {
        //Given
        val horoscopeResponse = anyResponse
        //When
        val predictionModel= horoscopeResponse.toDomain()
        //Then
        predictionModel.sign shouldBe horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope

    }
}