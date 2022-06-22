package com.example.myapplication

import junit.framework.Assert.assertEquals
import org.junit.Test

class CalculatorIntegrationTest {

    @Test
    fun testImpostoBrasil() {
        // Given
        val calculator = Calculator(GovernoBrasil())
        val valor = 100.0
        val pais = "BR"
        val expectedResult = 20.0

        // When
        val result = calculator.imposto(valor, pais)

        // Then
        assertEquals(expectedResult, result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testImpostoBrasilError() {
        // Given
        val calculator = Calculator(GovernoBrasil())
        val valor = 100.0
        val pais = "eua"
        val expectedResult = 20.0

        // When
        val result = calculator.imposto(valor, pais)

        // Then
        assertEquals(expectedResult, result)
    }
}