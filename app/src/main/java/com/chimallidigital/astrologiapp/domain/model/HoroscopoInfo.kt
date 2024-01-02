package com.chimallidigital.astrologiapp.domain.model

import com.chimallidigital.astrologiapp.R

sealed class HoroscopoInfo(val img: Int, val name: Int) {
    data object Aries : HoroscopoInfo(R.drawable.aries, R.string.aries)
    data object Taurus : HoroscopoInfo(R.drawable.tauro, R.string.tauro)
    data object Gemini : HoroscopoInfo(R.drawable.geminis, R.string.geminis)
    data object Cancer : HoroscopoInfo(R.drawable.cancer, R.string.cancer)
    data object Leo : HoroscopoInfo(R.drawable.leo, R.string.leo)
    data object Virgo : HoroscopoInfo(R.drawable.virgo, R.string.virgo)
    data object Libra : HoroscopoInfo(R.drawable.libra, R.string.libra)
    data object Scorpio : HoroscopoInfo(R.drawable.escorpio, R.string.escorpio)
    data object Sagittarius : HoroscopoInfo(R.drawable.sagitario, R.string.sagitatio)
    data object Capricorn : HoroscopoInfo(R.drawable.capricornio, R.string.capricornio)
    data object Aquarius : HoroscopoInfo(R.drawable.aquario, R.string.acuario)
    data object Pisces : HoroscopoInfo(R.drawable.piscis, R.string.piscis)
}