fun main() {
    fun prepareData (input: List<String>): List<String> = input
        .map {
            it.split(",").map {
                it.split("-").map {
                    it.toInt()
                }
            }
        }

    fun part1(input: List<String>): Int = prepareData(input).filter {
        it[0][0] <= it[1][0] && it[0][1] >= it[1][1] ||
        it[1][0] <= it[0][0] && it[1][1] >= it[0][1]
    }
    .size

    fun part2(input: List<String>): Int = prepareData(input).filter {
        !(it[0][1] < it[1][0] || it[1][1] < it[0][0])
    }
    .size

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
