package dev.richardlindsay.adventOfCode.dayOne

import dev.richardlindsay.adventOfCode.Utils

val utils = Utils()

fun main(){
    println("Project Successfully Set Up")
    val input = utils.loadFile("/dayOne/dayOneInput.txt")

    var total = 0
    var i = 0
    var j = 0
    var k = 0

    while (total != 2020 && i != 198){
        val inputI = input[i].toInt()
        j = i
        while (total != 2020 && j != 198){
            val inputJ = input[j].toInt()
            k = j
            while (total != 2020 && k != 199){
                val inputK = input[k].toInt()
                total = inputI + inputJ + inputK
                k++
            }
            j++
            println(j)
        }
        i++
    }

    val result = input[i - 1].toInt() * input[j - 1].toInt() * input[k - 1].toInt()

    println(result)
}