package com.example.stringcalculator2

class StringCalculator {
    fun add(numbers: String): Int {
        val delimiter = ","
        var sum = 0
        return when {
            numbers.isEmpty() -> 0
            else -> {
                numbers.split(delimiter).forEach { sum += it.toInt() }
                sum
            }
        }
    }
}
