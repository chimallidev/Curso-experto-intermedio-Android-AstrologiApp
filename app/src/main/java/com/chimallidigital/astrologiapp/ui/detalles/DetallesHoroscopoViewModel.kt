package com.chimallidigital.astrologiapp.ui.detalles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chimallidigital.astrologiapp.domain.model.HoroscopoModel
import com.chimallidigital.astrologiapp.domain.usecase.GetPrediction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetallesHoroscopoViewModel @Inject constructor(private val getPrediction: GetPrediction):
    ViewModel(){
    private var _state= MutableStateFlow<DetallesHoroscopoState>(DetallesHoroscopoState.Loading)
    val state: StateFlow<DetallesHoroscopoState> = _state

    lateinit var horoscopo: HoroscopoModel

    fun getHoroscopo(sign: HoroscopoModel){
        horoscopo= sign
        viewModelScope.launch {
            //Hilo principal
            _state.value= DetallesHoroscopoState.Loading
            val result= withContext(Dispatchers.IO){getPrediction(sign.name)} //Hilo secundario
            //Hilo principal
            if (result!=null){
                _state.value= DetallesHoroscopoState.Success(result.horoscope, result.sign, horoscopo)
            }else{
                _state.value= DetallesHoroscopoState.Error("Ha ocurrido un error, intentelo más tarde")
            }
        }
    }
}