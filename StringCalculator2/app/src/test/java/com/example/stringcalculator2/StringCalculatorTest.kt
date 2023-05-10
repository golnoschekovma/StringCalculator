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

    @Test
    fun unknownAmountOfIntegers_36() {
        val stringCalculator = StringCalculator()
        val actual = stringCalculator.add("1,2,3,4,5,6,7,8")
        val expected = 36
        assertEquals(expected, actual)
    }

    @Test
    fun linesBetweenNumbers_6() {
        val stringCalculator = StringCalculator()
        val actual = stringCalculator.add("1\n2,3")
        val expected = 6
        assertEquals(expected, actual)
    }

    @Test
    fun differentDelimiters_3() {
        val stringCalculator = StringCalculator()
        val actual = stringCalculator.add("//;\n1;2")
        val expected = 3
        assertEquals(expected, actual)
    }
}