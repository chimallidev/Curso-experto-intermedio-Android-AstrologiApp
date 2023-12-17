package com.chimallidigital.astrologiapp.ui.horoscopo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chimallidigital.astrologiapp.R
import com.chimallidigital.astrologiapp.domain.model.HoroscopoInfo

class HoroscopoAdapter(private var horoscopoList: List<HoroscopoInfo> = emptyList(),
    private val itemSeleccionado:(HoroscopoInfo) -> Unit) :
    RecyclerView.Adapter<HoroscopoViewHolder>() {

    fun updateList(list: List<HoroscopoInfo>){
        horoscopoList= list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopoViewHolder {
        return HoroscopoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscopo, parent, false)
        )
    }

    override fun getItemCount() = horoscopoList.size

    override fun onBindViewHolder(holder: HoroscopoViewHolder, position: Int) {
        holder.render(horoscopoList[position], itemSeleccionado)
    }
}