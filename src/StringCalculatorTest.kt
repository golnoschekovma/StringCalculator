import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import java.lang.NumberFormatException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class StringCalculatorTest {
    @Test
    fun testAddEmpty() {
        val calculator = StringCalculator()
        val actual: Int = calculator.add("")
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun testAddOneNumber() {
        val calculator = StringCalculator()
        val actual: Int = calculator.add("1")
        val expected = 1
        assertEquals(expected, actual)
    }

    @Test
    fun testAddTwoNumbers() {
        val calculator = StringCalculator()
        val actual: Int = calculator.add("1,2")
        val expected = 3
        assertEquals(expected, actual)
    }

    @Test
    fun testAddTenNumbers() {
        val calculator = StringCalculator()
        val actual: Int = calculator.add("1,2,3,4,5,6,7,8,9,10")
        val expected = 55
        assertEquals(expected, actual)
    }

    @Test
    fun testAddNumbersWithLinesInsteadCommas() {
        val calculator = StringCalculator()
        val actual: Int = calculator.add("1\n2,3")
        val expected = 6
        assertEquals(expected, actual)
    }

    @Test
    fun testAddNumbersWithCustomSeparator() {
        val calculator = StringCalculator()
        val actual: Int = calculator.add("//;\n1;2")
        val expected = 3
        assertEquals(expected, actual)
    }

    @Test
    fun testAddNegativeNumbersException() {
        val calculator = StringCalculator()
        val exception = assertFailsWith(
            exceptionClass = NumberFormatException::class,
            block = {
                calculator.add("1,2,3,4,5,-6,7,8,-9,-10")
            }
        )
        assertThat(exception.message, equalTo("negatives not allowed: -6, -9, -10"))
    }

    @Test
    fun testAddIgnoreNumbersBigger1000() {
        val calculator = StringCalculator()
        val actual: Int = calculator.add("2,1001")
        val expected = 2
        assertEquals(expected, actual)
    }

    @Test
    fun testAddWithLongDelimiter() {
        val calculator = StringCalculator()
        val actual: Int = calculator.add("//[***]\n1***2***3")
        val expected = 6
        assertEquals(expected, actual)
    }

    @Test
    fun testAddWithDifferentDelimiters() {
        val calculator = StringCalculator()
        val actual: Int = calculator.add("//[*][%]\n1*2%3")
        val expected = 6
        assertEquals(expected, actual)
    }

    @Test
    fun testAddWithDifferentLongDelimiters() {
        val calculator = StringCalculator()
        val actual: Int = calculator.add("//[*%#][%^&]\n1*%#2%^&3")
        val expected = 6
        assertEquals(expected, actual)
    }
}