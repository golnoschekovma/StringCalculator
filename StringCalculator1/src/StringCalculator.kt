import java.lang.NumberFormatException

class StringCalculator {
    fun add(numbers: String): Int {
        if (numbers.isEmpty())
            return 0

        val delimiters = listOf("\n", ",").toMutableList()

        if (numbers.length > 5) {
            val prefix = numbers.substring(0..1)

            if (prefix == "//") {
                delimiters.remove(",")

                if (numbers[2].toString() == "[") {
                    numbers
                        .substringAfter("[")
                        .substringBeforeLast("]")
                        .split("][")
                        .forEach {
                            delimiters.add(it)
                        }
                }
                else {
                    numbers
                        .substringAfter("[")
                        .substringBefore("\n")
                        .forEach { delimiters.add(it.toString()) }
                }
            }
        }

        var sum = 0
        val negatives = emptyList<String>().toMutableList()
        numbers
            .split(*delimiters.toTypedArray())
            .forEach {
                val intNumber = it.toIntOrNull() ?: 0

                if (intNumber <= 1000) {
                    if (intNumber < 0)
                        negatives.add(it)
                    else
                        sum += intNumber
                }
            }

        if (negatives.isNotEmpty())
            throw NumberFormatException("negatives not allowed: " + negatives.joinToString())

        return sum;
    }
}
