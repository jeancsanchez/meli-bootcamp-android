package com.example.myapplication

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.*

class CalculatorTest {

    @Mock
    private lateinit var governo: Governo

    @InjectMocks
    private lateinit var calculator: Calculator

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun testImpostoBrasil() {
        // Given
        val valor = 100.0
        val pais = "Brasil"
        val impostoCalculado = 10.0
        whenever(governo.calcularImposto(any(), any())) doReturn impostoCalculado

        // When
        val result = calculator.imposto(valor, pais)

        // Then
        verify(governo).calcularImposto(eq(valor), eq(pais))
        assertEquals(impostoCalculado + 10, result)
    }

    @Test
    fun testImpostoEUA() {
        // Given
        val valor = 100.0
        val pais = "EUA"
        val expectedImposto = 20.0

        // When
        val result = calculator.imposto(valor, pais)

        // Then
        assertEquals(expectedImposto, result)
    }
}