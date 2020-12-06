package dev.richardlindsay.adventOfCode.dayThree

import dev.richardlindsay.adventOfCode.Utils
import java.math.BigInteger

val utils = Utils()

fun main(){
    val input = utils.loadFile("/dayThree/dayThreeInput.txt")
    dayThreePartOne(input)
    dayThreePartTwo(input)
}

fun dayThreePartOne(input: List<String>){
    val trees = calculatePath(input, Pair(3, 1))
    assert(trees == BigInteger.valueOf(268))
    println(trees)
}

fun dayThreePartTwo(input: List<String>){
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
    println(trees)
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