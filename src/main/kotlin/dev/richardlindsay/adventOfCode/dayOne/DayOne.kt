package dev.richardlindsay.adventOfCode.dayOne

import dev.richardlindsay.adventOfCode.Utils

val utils = Utils()


fun main(){
    val input = utils.loadFile("/dayOne/dayOneInput.txt").map { it.toInt() }.toHashSet()
    dayOnePartOne(input)
    dayOnePartTwo(input)
}

fun dayOnePartOne(input: HashSet<Int>){
    var result = 0

    input.first {
        val remainder1 = 2020 - it
        if (input.contains(remainder1)) {
            result = it * remainder1
            return@first true
        }
        false
    }
    println("Day 1 Part 1 Result : $result")
}

fun dayOnePartTwo(input: HashSet<Int>){

    var result = 0

    input.first { input1 ->
        val r1 = 2020 - input1

        input.any { input2 ->
            val r2 = r1 - input2
            if(input.contains(r2)){
                result = input1 * input2 * r2
                return@first true
            }
            false
        }
        false
    }
    print("Day 1 Part 2 Result : $result")
}