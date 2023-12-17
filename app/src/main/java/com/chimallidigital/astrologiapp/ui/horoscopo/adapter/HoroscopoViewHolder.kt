package com.chimallidigital.astrologiapp.ui.horoscopo.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.chimallidigital.astrologiapp.databinding.ItemHoroscopoBinding
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo

class HoroscopoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopoBinding.bind(view)

    fun render(horoscopoInfo: HoroscopoInfo, itemSeleccionado: (HoroscopoInfo) -> Unit) {
        val context = binding.tvHoroscopo.context

        binding.ivHoroscopo.setImageResource(horoscopoInfo.img)
        binding.tvHoroscopo.text = context.getString(horoscopoInfo.name)

        binding.itemRvHoroscopo.setOnClickListener {
            startRotationAnimation(binding.ivHoroscopo, newLambda = {itemSeleccionado(horoscopoInfo)})
            //itemSeleccionado(horoscopoInfo) }

        }
    }

    private fun startRotationAnimation(view: View, newLambda:()-> Unit) {
        view.animate().apply {
            duration= 500
            interpolator= LinearInterpolator()
            rotationBy(360f)
            withEndAction { newLambda() }
            start()
        }

    }
}