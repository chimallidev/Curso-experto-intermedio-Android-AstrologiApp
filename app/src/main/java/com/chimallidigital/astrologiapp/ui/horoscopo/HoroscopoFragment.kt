package com.chimallidigital.astrologiapp.ui.horoscopo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.chimallidigital.astrologiapp.databinding.FragmentHoroscopoBinding
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
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel
import com.chimallidigital.astrologiapp.ui.horoscopo.adapter.HoroscopoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoFragment : Fragment() {
    private val horoscopoViewModel by viewModels<HoroscopoViewModel>()
    private lateinit var horoscopoAdapter: HoroscopoAdapter

    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }
    private fun initList(){
        horoscopoAdapter= HoroscopoAdapter(itemSeleccionado = {
            val type= when(it){
                Aquarius -> HoroscopoModel.Aquarius
                Aries -> HoroscopoModel.Aries
                Cancer -> HoroscopoModel.Cancer
                Capricorn -> HoroscopoModel.Capricorn
                Scorpio -> HoroscopoModel.Scorpio
                Gemini -> HoroscopoModel.Gemini
                Leo -> HoroscopoModel.Leo
                Libra -> HoroscopoModel.Libra
                Pisces-> HoroscopoModel.Pisces
                Sagittarius -> HoroscopoModel.Sagittarius
                Taurus -> HoroscopoModel.Taurus
                Virgo -> HoroscopoModel.Virgo
            }
            findNavController().navigate(
                HoroscopoFragmentDirections.actionHoroscopoFragmentToDetallesHoroscopoActivity(type)
            )
        })

        binding.rvHoroscopo.apply {
            layoutManager= GridLayoutManager(context,2)
            adapter= horoscopoAdapter
        }
    }
    private fun initUIState(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopoViewModel.horoscopo.collect{
                    //Cambios en Horoscopo
                    horoscopoAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}