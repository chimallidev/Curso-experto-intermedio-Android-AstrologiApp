package com.chimallidigital.astrologiapp.ui.detalles

import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel

sealed class DetallesHoroscopoState {
    data object Loading: DetallesHoroscopoState()
    data class Error(val error: String): DetallesHoroscopoState()
    data class Success(val prediction: String, val sign: String, val horoscopoModel: HoroscopoModel): DetallesHoroscopoState()
}