fun main() {
    fun getListOfCalories(input: List<String>): List<Int> {
        return input.fold(mutableListOf(0)) { acc, item ->
            if (item.isBlank()) acc.add(0)
            else acc[acc.size - 1] = acc.last() + item.toInt()
            acc
        }
    }

    fun part1(input: List<String>): Int {
        return getListOfCalories(input)
            .max()
    }

    fun part2(input: List<String>): Int {
        return getListOfCalories(input)
            .sortedDescending()
            .take(3)
            .sum()
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
