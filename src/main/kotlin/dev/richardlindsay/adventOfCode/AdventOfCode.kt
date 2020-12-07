package dev.richardlindsay.adventOfCode

import dev.richardlindsay.adventOfCode.dayFive.DayFive
import dev.richardlindsay.adventOfCode.dayFour.DayFour
import dev.richardlindsay.adventOfCode.dayOne.DayOne
import dev.richardlindsay.adventOfCode.dayThree.DayThree
import dev.richardlindsay.adventOfCode.dayTwo.DayTwo

val dayOne = DayOne()
val dayTwo = DayTwo()
val dayThree = DayThree()
val dayFour = DayFour()
val dayFive = DayFive()

fun main(){
    dayOne.runSolution("/dayOneInput.txt")
    dayTwo.runSolution("/dayTwoInput.txt")
    dayThree.runSolution("/dayThreeInput.txt")
    dayFour.runSolution("/dayFourInput.txt")
//    dayFive.runSolution("/dayFiveInput.txt")
}

class AdventOfCode