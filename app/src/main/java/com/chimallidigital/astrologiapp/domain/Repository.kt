package com.chimallidigital.astrologiapp.domain

import com.chimallidigital.astrologiapp.domain.model.PredictionModel


interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}