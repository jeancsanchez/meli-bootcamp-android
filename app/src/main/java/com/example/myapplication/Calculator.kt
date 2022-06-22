package com.example.myapplication

class Calculator(
    val governo: Governo
) {

    fun imposto(valor: Double, pais: String): Double {
        val comissao = 10.0
        val imposto = governo.calcularImposto(valor, pais)
        return comissao + imposto
    }

    fun add(a: Int, b: Int) = a + b

    fun remove(a: Int, b: Int): Int {
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Int, b: Int): Int {
        return 0
    }
}