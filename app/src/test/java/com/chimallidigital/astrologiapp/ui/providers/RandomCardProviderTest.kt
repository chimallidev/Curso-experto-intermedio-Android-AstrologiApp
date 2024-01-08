package com.chimallidigital.astrologiapp.ui.providers

import junit.framework.TestCase.assertNotNull
import org.junit.Test

class RandomCardProviderTest {
    @Test
    fun `getRandomCard should return a random card`() {
        val randomCard = RandomCardProvider()

        val card= randomCard.getLucky()

        assertNotNull(card)
    }
}