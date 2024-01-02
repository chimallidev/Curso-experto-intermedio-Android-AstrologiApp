package com.chimallidigital.astrologiapp.data.network

import com.chimallidigital.astrologiapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AstrologiAPIService {
    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign: String): PredictionResponse
}