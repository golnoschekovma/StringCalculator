package com.example.stringcalculator2

import org.junit.Assert.assertEquals
import org.junit.Test

class StringCalculatorTest {
    @Test
    fun empty_0() {
        val stringCalculator = StringCalculator()
        val actual = stringCalculator.add("")
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun oneInteger_1() {
        val stringCalculator = StringCalculator()
        val actual = stringCalculator.add("1")
        val expected = 1
        assertEquals(expected, actual)
    }

    @Test
    fun twoIntegers_3() {
        val stringCalculator = StringCalculator()
        val actual = stringCalculator.add("1,2")
        val expected = 3
        assertEquals(expected, actual)
    }
}