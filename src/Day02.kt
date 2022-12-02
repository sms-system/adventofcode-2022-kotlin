typealias Moves = List<Pair<Int, Int>>

fun Moves.calculateScore(): Int = fold(0) { acc, move ->
    var roundResult =
        if (move.first == move.second) { 1 }
        else { if (move.second > move.first) { 2 } else { 0 } }
    if (move.first == 1 && move.second == 3) { roundResult = 0 }
    else if (move.first == 3 && move.second == 1) { roundResult = 2 }

    acc + move.second + roundResult * 3
}

fun main() {
    val weight = mapOf("A" to 1, "B" to 2, "C" to 3, "X" to 1, "Y" to 2, "Z" to 3)

    fun getListOfMoves(input: List<String>): Moves = input.map {
        it
            .split(" ")
            .map { weight[it]!! }
            .zipWithNext()
            .single()
    }

    fun part1(input: List<String>): Int {
        return getListOfMoves(input)
            .calculateScore()
    }

    fun part2(input: List<String>): Int {
        return getListOfMoves(input)
            .map {
                val opponentMove = if (it.second === 1) { it.first + 1 }
                    else { it.first }
                val yourMove = if (it.second === 2) { opponentMove }
                    else { opponentMove % 3 + 1 }
                Pair(it.first, yourMove)
            }
            .calculateScore()
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
