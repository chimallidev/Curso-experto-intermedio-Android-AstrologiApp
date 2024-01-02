package com.chimallidigital.astrologiapp.ui.detalles

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.chimallidigital.astrologiapp.R
import com.chimallidigital.astrologiapp.databinding.ActivityDetallesHoroscopoBinding
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.Aquarius
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.Aries
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.Cancer
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.Capricorn
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.Gemini
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.Leo
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.Libra
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.Pisces
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.Sagittarius
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.Scorpio
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.Taurus
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel.Virgo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetallesHoroscopoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetallesHoroscopoBinding
    private val horoscopoDetallesViewModel: DetallesHoroscopoViewModel by viewModels()

    private val args: DetallesHoroscopoActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesHoroscopoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        horoscopoDetallesViewModel.getHoroscopo(args.type)
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoDetallesViewModel.state.collect {
                    when (it) {
                        is DetallesHoroscopoState.Error -> errorState()
                        DetallesHoroscopoState.Loading -> loadingState()
                        is DetallesHoroscopoState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.pb.isVisible = true
    }

    private fun errorState() {
        binding.pb.isVisible = false
    }

    private fun successState(state: DetallesHoroscopoState.Success) {
        binding.pb.isVisible = false
        binding.tvDetallesTitulo.text= when(state.sign){
            "Capricorn"-> getString(R.string.capricornio)
            "Aquarius"->getString(R.string.acuario)
            "Sagittarius"-> getString(R.string.sagitatio)
            "Pisces"-> getString(R.string.piscis)
            "Scorpio"-> getString(R.string.escorpio)
            "Taurus"-> getString(R.string.tauro)
            "Gemini"-> getString(R.string.geminis)
            else-> state.sign
        }
        getString(R.string.acuario)
        binding.tvBody.text= state.prediction

        val image= when(state.horoscopoModel){
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }
        binding.ivDetalles.setImageResource(image)
    }
}