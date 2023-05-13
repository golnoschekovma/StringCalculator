package com.example.stringcalculator2

class StringCalculator {
    fun add(input: String): Int = input.split(",", "\n").sumOf { it.toIntOrNull() ?: 0 }
}
