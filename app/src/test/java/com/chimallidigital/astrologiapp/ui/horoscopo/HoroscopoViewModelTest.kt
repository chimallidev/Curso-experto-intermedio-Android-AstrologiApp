package com.chimallidigital.astrologiapp.ui.horoscopo

import com.chimallidigital.astrologiapp.data.providers.HoroscopoProvider
import com.chimallidigital.astrologiapp.motherobject.HoroscopoMotherObject.horoscopoInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test


class HoroscopoViewModelTest {

    @MockK
    lateinit var horoscopoProvider: HoroscopoProvider

    private lateinit var viewModel: HoroscopoViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `when viewModel is created then horoscopes are loaded`() {
        every { horoscopoProvider.gethoroscopos() } returns horoscopoInfoList
        viewModel = HoroscopoViewModel(horoscopoProvider)

        val horoscopos = viewModel.horoscopo.value

        assertTrue(horoscopos.isNotEmpty())
    }
}