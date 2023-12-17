package com.chimallidigital.astrologiapp.data.providers

import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.*
import javax.inject.Inject

class HoroscopoProvider @Inject constructor(){
    fun gethoroscopos(): List<HoroscopoInfo>{
        return listOf(
            Aries,
            Tauro,
            Geminis,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Escorpio,
            Sagitario,
            Capricornio,
            Acuario,
            Piscis
        )
    }
}