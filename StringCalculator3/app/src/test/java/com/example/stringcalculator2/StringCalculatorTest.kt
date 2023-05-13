package com.example.stringcalculator2

import org.junit.Assert.assertEquals
import org.junit.Test

class StringCalculatorTest {
    private val stringCalculator = StringCalculator()

    @Test
    fun `when "" should return 0`() {
        val result = stringCalculator.add("")

        assertEquals(0, result)
    }

    @Test
    fun `when 1 should return 1`() {
        val result = stringCalculator.add("1")

        assertEquals(1, result)
    }

    @Test
    fun `when 1,2 should return 3`() {
        val result = stringCalculator.add("1,2")

        assertEquals(3, result)
    }
}