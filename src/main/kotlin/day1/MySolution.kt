package day1

class MySolution(private val input: List<String>) {

    fun calculateCodeSum(): Int {
        val extractedCodes: MutableList<Int> = ArrayList()

        for (string in input) {
            val formattedCode = replaceWordsWithNumber(string)
            val code = extractCode(formattedCode)
            println(code)
            extractedCodes.add(code)
        }
        return extractedCodes.toTypedArray().sum()
    }

    private fun replaceWordsWithNumber(input: String): String {
        var formattedInput = input

        while (doesContainNumberWord(formattedInput)) {
            val finding = formattedInput.findAnyOf(NUMBERWORDS)
            if (finding != null) {
                formattedInput = formattedInput.replace(
                    finding.second,
                    wordToNumber(finding.second)
                )
            }
        }
        return formattedInput
    }

    private fun extractCode(input: String): Int {
        val result = input.filter { it.isDigit() }

        return result.length.let {
            println(result)
            when {
                it == 2 -> result.toInt()
                it < 2 -> (result + result).toInt()
                it > 2 -> ("${result.first()}${result.last()}").toInt()
                else -> -1
            }
        }
    }

    private fun doesContainNumberWord(input: String): Boolean {
        for (numberPair in MAP) {
            if (input.contains(numberPair.key)) {
                return true
            }
        }
        return false
    }

    private fun wordToNumber(input: String): String {
        return when (input) {
            "one" -> "o1e"
            "two" -> "t2o"
            "three" -> "t3e"
            "four" -> "f4r"
            "five" -> "f5e"
            "six" -> "s6x"
            "seven" -> "s7n"
            "eight" -> "e8t"
            "nine" -> "n9e"
            else -> "-1"
        }
    }

    companion object {
        private val MAP = mapOf(
            "one" to "o1e",
            "two" to "t2o",
            "three" to "t2e",
            "four" to "f4r",
            "five" to "f5e",
            "six" to "s6x",
            "seven" to "s7n",
            "eight" to "e8t",
            "nine" to "n9e,"
        )
        private val NUMBERWORDS = arrayListOf(
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
        )
    }
}