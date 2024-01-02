package com.chimallidigital.astrologiapp.domain.usecase

import com.chimallidigital.astrologiapp.domain.Repository
import javax.inject.Inject

class GetPrediction @Inject constructor(private val repository: Repository){
    suspend operator fun invoke(sign: String)= repository.getPrediction(sign)

}