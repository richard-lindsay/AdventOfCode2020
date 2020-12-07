package dev.richardlindsay.adventOfCode.dayThree

import dev.richardlindsay.adventOfCode.Solution
import java.math.BigInteger

class DayThree: Solution() {
    override fun partOne(input: List<String>) {
        val trees = calculatePath(input, Pair(3, 1))
        assert(trees == BigInteger.valueOf(268))
        println("Day 3 Part 1 Result: $trees")
    }

    override fun partTwo(input: List<String>) {
        val vectors = listOf(
            Pair(1, 1),
            Pair(3, 1),
            Pair(5, 1),
            Pair(7, 1),
            Pair(1, 2)
        )

        val trees = vectors
            .map { calculatePath(input, it) }
            .reduce(BigInteger::multiply)
        assert(trees == BigInteger.valueOf(3093068400))
        println("Day 3 Part 2 Result: $trees")
    }


    fun calculatePath(input: List<String>, vector: Pair<Int, Int>): BigInteger {
        var x = 0
        var y = 0

        var trees = 0

        input.forEach { line ->
            if (y % vector.second == 0){
                if (line[x].toString() == "#") trees++
                x += vector.first
                if (x >= line.length) x -= line.length
            }
            y++
        }
        return trees.toBigInteger()
    }

}
