package com.example.myapplication

class GovernoBrasil : Governo {

    override fun calcularImposto(valor: Double, pais: String): Double {
        if (pais == "BR") {
            return valor * 0.10
        }

        throw IllegalArgumentException()
    }
}