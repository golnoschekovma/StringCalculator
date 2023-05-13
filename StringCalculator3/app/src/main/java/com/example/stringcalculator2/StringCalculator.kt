package com.example.stringcalculator2

class StringCalculator {
    fun add(input: String): Int {
        return when {
            input.isEmpty() -> 0
            input.length == 1 -> input.toInt()
            else -> {
                input.split(",").sumOf { it.toInt() }
            }
        }
    }
}
