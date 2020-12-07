package dev.richardlindsay.adventOfCode.dayOne

import dev.richardlindsay.adventOfCode.Solution
import dev.richardlindsay.adventOfCode.Utils


class DayOne: Solution() {
    override fun partOne(input: List<String>) {
        var result = 0

        val inputHS = input.map { it.toInt() }.toHashSet()

        inputHS.first {
            val remainder1 = 2020 - it
            if (inputHS.contains(remainder1)) {
                result = it * remainder1
                return@first true
            }
            false
        }

        assert(result == 1003971)
        println("Day 1 Part 1 Result: $result")
    }

    override fun partTwo(input: List<String>) {

        var result = 0
        val inputHS = input.map { it.toInt() }.toHashSet()

        inputHS.first { input1 ->
            val r1 = 2020 - input1

            inputHS.any { input2 ->
                val r2 = r1 - input2
                if(inputHS.contains(r2)){
                    result = input1 * input2 * r2
                    return@first true
                }
                false
            }
            false
        }
        assert(result == 84035952)
        println("Day 1 Part 2 Result: $result")
    }
}
