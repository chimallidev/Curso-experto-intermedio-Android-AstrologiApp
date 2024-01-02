package com.chimallidigital.astrologiapp.data.providers

import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.Aquarius
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.Aries
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.Cancer
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.Capricorn
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.Gemini
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.Leo
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.Libra
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.Pisces
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.Sagittarius
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.Scorpio
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.Taurus
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo.Virgo
import javax.inject.Inject

class HoroscopoProvider @Inject constructor(){
    fun gethoroscopos(): List<HoroscopoInfo>{
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}