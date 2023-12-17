package com.chimallidigital.astrologiapp.domain.model

import com.chimallidigital.astrologiapp.R

sealed class HoroscopoInfo(val img: Int, val name: Int) {
    object Aries : HoroscopoInfo(R.drawable.aries, R.string.aries)
    object Tauro : HoroscopoInfo(R.drawable.tauro, R.string.tauro)
    object Geminis : HoroscopoInfo(R.drawable.geminis, R.string.geminis)
    object Cancer : HoroscopoInfo(R.drawable.cancer, R.string.cancer)
    object Leo : HoroscopoInfo(R.drawable.leo, R.string.leo)
    object Virgo : HoroscopoInfo(R.drawable.virgo, R.string.virgo)
    object Libra : HoroscopoInfo(R.drawable.libra, R.string.libra)
    object Escorpio : HoroscopoInfo(R.drawable.escorpio, R.string.escorpio)
    object Sagitario : HoroscopoInfo(R.drawable.sagitario, R.string.sagitatio)
    object Capricornio : HoroscopoInfo(R.drawable.capricornio, R.string.capricornio)
    object Acuario : HoroscopoInfo(R.drawable.aquario, R.string.acuario)
    object Piscis : HoroscopoInfo(R.drawable.piscis, R.string.piscis)
}