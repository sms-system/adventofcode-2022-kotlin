fun main() {
    fun getItemPriority (item: String): Int = if (item.uppercase() == item) {
        item.first().toInt() - 38
    } else {
        item.first().toInt() - 96
    }

    fun part1(input: List<String>): Int = input
        .map {
            it.substring(0, it.length / 2).split("")
                .intersect(it.substring(it.length / 2).split(""))
                .filter { !it.isBlank() }
                .single()
        }
        .map { getItemPriority(it) }
        .sum()

    fun part2(input: List<String>): Int = input
        .chunked(3)
        .map {
            it[0].split("")
                .intersect(it[1].split(""))
                .intersect(it[2].split(""))
                .filter { !it.isBlank() }
                .single()
        }
        .map { getItemPriority(it) }
        .sum()

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
