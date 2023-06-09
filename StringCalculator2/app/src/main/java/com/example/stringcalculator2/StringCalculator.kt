package com.example.stringcalculator2

class StringCalculator {
    fun add(input: String): Int {
        val delimiters = arrayOf(",", "\n")
        val numbers : String;

        when {
            input.isEmpty() -> return 0
            input.length > 1 && input.substring(0..1) == "//" -> {
                delimiters[0] = input[2].toString()
                numbers = input.substringAfter("\n")
            }
            else -> numbers = input
        }

        return numbers.split(*delimiters).sumOf { it.toInt() }
    }
}
