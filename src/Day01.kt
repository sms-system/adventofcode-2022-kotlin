fun main() {
    fun getListOfCalories(input: List<String>): List<Int> {
        var acc: Int = 0
        val data = input.fold(listOf<Int>()) { a, b ->
            if (b == "") {
                val ret = a + acc
                acc = 0
                ret
            } else {
                acc += b.toInt()
                a
            }
        }
        return data + acc
    }

    fun part1(input: List<String>): Int {
        val listOfCalories = getListOfCalories(input)
        return listOfCalories.maxOrNull()?:0
    }

    fun part2(input: List<String>): Int {
        val listOfCalories = getListOfCalories(input).sortedDescending()
        return listOfCalories[0] + listOfCalories[1] + listOfCalories[2]
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
