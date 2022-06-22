package com.example.myapplication

class GovernoEUA : Governo {

    override fun calcularImposto(valor: Double, pais: String): Double {
        return valor * 0.20
    }
}