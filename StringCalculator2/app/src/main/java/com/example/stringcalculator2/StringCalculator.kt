package com.example.stringcalculator2

class StringCalculator {
    fun add(_numbers: String): Int {
        val delimiters = arrayOf(",", "\n").toMutableList()
        var numbers = _numbers
        var sum = 0

        when {
            numbers.isEmpty() -> return 0
            numbers.length > 1 && numbers.substring(0..1) == "//" -> {
                delimiters[0] = numbers[2].toString()
                numbers = numbers.substringAfter("\n")
            }
        }

        numbers.split(*delimiters.toTypedArray()).forEach {
            sum += it.toInt()
        }
        return sum
    }
}
