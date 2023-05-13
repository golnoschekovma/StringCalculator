package com.example.stringcalculator2

class StringCalculator {
    fun add(input: String): Int {
         return if (input.isEmpty()) 0 else input.toInt()
    }
}
