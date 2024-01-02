package com.chimallidigital.astrologiapp.data.network

import android.util.Log
import com.chimallidigital.astrologiapp.domain.Repository
import com.chimallidigital.astrologiapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: AstrologiAPIService): Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("nona", "Ha ocurrido un error ${it.message}") }
        return null
    }
}