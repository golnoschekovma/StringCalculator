package com.example.stringcalculator2

import org.junit.Assert.assertEquals
import org.junit.Test

class StringCalculatorTest {
    @Test
    fun `when "" should return 0`() {
        val result = StringCalculator().add("")

        assertEquals(0, result)
    }

}