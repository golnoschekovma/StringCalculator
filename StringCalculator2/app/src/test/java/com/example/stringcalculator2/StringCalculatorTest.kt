package com.example.stringcalculator2

import org.junit.Assert.assertEquals
import org.junit.Test

class StringCalculatorTest {
    @Test
    fun `when empty param should return 0`() {
        val stringCalculator = StringCalculator()

        val actual = stringCalculator.add("")

        assertEquals(0, actual)
    }

    @Test
    fun `when 1 should return 1`() {
        val stringCalculator = StringCalculator()

        val actual = stringCalculator.add("1")

        assertEquals(1, actual)
    }

    @Test
    fun `when 1,2 should return 3`() {
        val stringCalculator = StringCalculator()

        val actual = stringCalculator.add("1,2")

        assertEquals(3, actual)
    }

    @Test
    fun unknownAmountOfIntegers_36() {
        val stringCalculator = StringCalculator()

        val actual = stringCalculator.add("1,2,3,4,5,6,7,8")

        assertEquals(36, actual)
    }

    @Test
    fun `when 1 NewLine 2,3 should return 6`() {
        val stringCalculator = StringCalculator()

        val actual = stringCalculator.add("1\n2,3")

        assertEquals(6, actual)
    }

    @Test
    fun differentDelimiters_3() {
        val stringCalculator = StringCalculator()
        val actual = stringCalculator.add("//;\n1;2")
        val expected = 3
        assertEquals(expected, actual)
    }
}