package dev.richardlindsay.adventOfCode.dayFive

import dev.richardlindsay.adventOfCode.Solution
import kotlin.math.floor

class DayFive: Solution() {

    override fun partOne(input: List<String>) {
        val seatNumbers = getSeatNumber(input)
        val result = seatNumbers.maxOrNull()

        assert(result == 978)
        println("Day 5 Part 1 Result: $result")
    }

    override fun partTwo(input: List<String>) {
        val seatNumbers = getSeatNumber(input)

        val possibleSeatNumbers = 50..1000

        val result = possibleSeatNumbers.minus(seatNumbers).sorted()
        assert(result[0] == 727)
        println("Day 5 Part 2 Result: ${result[0]}")
    }

    fun getSeatNumber(input: List<String>): List<Int>{
        return input.map {
            val row = it.subSequence(0, 7).toString()
            val seat = it.subSequence(7, 10).toString()

            val rowNumber = binarySearch(0, 127, row)
            val seatNumber = binarySearch(0, 7, seat)
            val seatId = (rowNumber * 8) + seatNumber
            seatId
        }
    }

    fun binarySearch(lowerLimit: Int, upperLimit: Int, path: String): Int {
        var ll = lowerLimit
        var ul = upperLimit

        path.split("").forEach {

            val middle = floor((ll + ul) / 2.0).toInt()

            if (it == "F" || it == "L") ul = middle - 1
            if (it == "B" || it == "R") ll = middle + 1
        }
        return ll
    }
}
