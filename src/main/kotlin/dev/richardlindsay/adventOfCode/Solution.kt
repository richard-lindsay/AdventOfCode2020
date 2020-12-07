package dev.richardlindsay.adventOfCode

abstract class Solution {

    val utils = Utils()

    abstract fun partOne(input: List<String>)

    abstract fun partTwo(input: List<String>)

    fun runSolution(inputFile: String){
        val input = utils.loadFile(inputFile)

        partOne(input)
        partTwo(input)
    }
}
