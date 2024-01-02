package com.chimallidigital.astrologiapp.ui.providers

import com.chimallidigital.astrologiapp.R
import com.chimallidigital.astrologiapp.ui.model.LuckyModel
import javax.inject.Inject
import kotlin.random.Random

class RandomCardProvider @Inject constructor(){
    fun getLucky(): LuckyModel?{
        return when(Random.nextInt(0,32)){
            0-> LuckyModel(R.drawable.card_fool, R.string.suerte_0)
            1-> LuckyModel(R.drawable.card_moon, R.string.suerte_1)
            2-> LuckyModel(R.drawable.card_hermit, R.string.suerte_2)
            3-> LuckyModel(R.drawable.card_star, R.string.suerte_3)
            4-> LuckyModel(R.drawable.card_sun, R.string.suerte_4)
            5-> LuckyModel(R.drawable.card_sword, R.string.suerte_5)
            6-> LuckyModel(R.drawable.card_chariot, R.string.suerte_6)
            7-> LuckyModel(R.drawable.card_death, R.string.suerte_7)
            8-> LuckyModel(R.drawable.card_devil, R.string.suerte_8)
            9-> LuckyModel(R.drawable.card_empress, R.string.suerte_9)
            10-> LuckyModel(R.drawable.card_hierophant, R.string.suerte_10)
            11-> LuckyModel(R.drawable.card_ace_pentacles, R.string.suerte_11)
            12-> LuckyModel(R.drawable.card_judgement, R.string.suerte_12)
            13-> LuckyModel(R.drawable.card_world, R.string.suerte_13)
            14-> LuckyModel(R.drawable.card_wheel_fortune, R.string.suerte_14)
            15-> LuckyModel(R.drawable.card_tower, R.string.suerte_15)
            16-> LuckyModel(R.drawable.card_temperance, R.string.suerte_16)
            17-> LuckyModel(R.drawable.card_strength, R.string.suerte_17)
            18-> LuckyModel(R.drawable.card_queen_wands, R.string.suerte_18)
            19-> LuckyModel(R.drawable.card_queen_swords, R.string.suerte_19)
            20-> LuckyModel(R.drawable.card_priestess, R.string.suerte_20)
            21-> LuckyModel(R.drawable.card_nine_wands, R.string.suerte_21)
            22-> LuckyModel(R.drawable.card_page_wands, R.string.suerte_22)
            23-> LuckyModel(R.drawable.card_magician, R.string.suerte_23)
            24-> LuckyModel(R.drawable.card_king_pentacles, R.string.suerte_24)
            25-> LuckyModel(R.drawable.card_two_pentacles, R.string.suerte_25)
            26-> LuckyModel(R.drawable.card_queen_pentacles, R.string.suerte_26)
            27-> LuckyModel(R.drawable.card_justice, R.string.suerte_27)
            28-> LuckyModel(R.drawable.card_king_swords, R.string.suerte_28)
            29-> LuckyModel(R.drawable.card_king_wands, R.string.suerte_29)
            30-> LuckyModel(R.drawable.card_king_cups, R.string.suerte_30)
            31-> LuckyModel(R.drawable.card_king_pentacles, R.string.suerte_31)
            else -> null
        }
    }
}