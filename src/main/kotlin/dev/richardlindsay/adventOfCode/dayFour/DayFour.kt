package dev.richardlindsay.adventOfCode.dayFour

import dev.richardlindsay.adventOfCode.Solution
import dev.richardlindsay.adventOfCode.Utils


val utils = Utils()

class DayFour: Solution() {
    val keys = listOf(
        "byr",
        "iyr",
        "eyr",
        "hgt",
        "hcl",
        "ecl",
        "pid"
    )

    override fun partOne(input: List<String>) {
        val passports = parseInput(input)
        val result = passports.filter { passport -> keys.all { passport.contains(it) } }.count()

        assert(result == 192)
        println("Day 4 Part 1 Result: $result")
    }

    override fun partTwo(input: List<String>) {
        val passports = parseInput(input)

        val fieldValidatedPassports = passports.filter { passport -> keys.all { passport.contains(it) } }

        val splitPassports = fieldValidatedPassports.map { it.split(" ") }

        val results = splitPassports.filter { pp -> pp.all { validateField(it) } }.count()
        assert(results == 101)
        println("Day 4 Part 2 Result: $results")
    }

    // parse the input, splitting the list when it detects a null line
    fun parseInput(input: List<String>): List<String> {
        val passports: MutableList<String> = mutableListOf()
        var passport = ""

        input.forEach {
            if(it.isNotBlank()) {
                passport += (it + " ")
            }
            else {
                passports.add(passport)
                passport = ""
            }
        }
        return passports
    }


    fun validateField(fieldString: String): Boolean {
        if (fieldString.isBlank()) return true
        val key = fieldString.split(":")[0]
        val value = fieldString.split(":")[1]

        return when(key){
            "byr" -> {
                value.toInt() in 1920..2002
            }
            "iyr" -> {
                value.toInt() in 2010..2020
            }
            "eyr" -> {
                value.toInt() in 2020..2030
            }
            "hgt" -> {
                if (value.contains("cm")){
                    return value.filter { it.isDigit() }.toInt() in 150..193
                } else if (value.contains("in")){
                    return value.filter { it.isDigit() }.toInt() in 59..76
                } else {
                    false
                }
            }
            "hcl" -> {
                value.matches(Regex("#([0-f]{6})"))
            }
            "ecl" -> {
                value in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
            }
            "pid" -> {
                value.length == 9
            }
            "cid" -> true
            else -> false
        }
    }
}
//
//
//fun main(){
//    val input = utils.loadFile("/dayFourInput.txt")
//
//    dayFourPartOne(input)
//    dayFourPartTwo(input)
//}
//
//fun dayFourPartOne(input: List<String>){
//    val keys = listOf(
//        "byr",
//        "iyr",
//        "eyr",
//        "hgt",
//        "hcl",
//        "ecl",
//        "pid"
//    )
//
//    val passports = parseInput(input)
//    val result = passports.filter { passport -> keys.all { passport.contains(it) } } // 191: too low
//
//    println(result.count())
//}
//
//fun dayFourPartTwo(input: List<String>){
//    val keys = listOf(
//        "byr",
//        "iyr",
//        "eyr",
//        "hgt",
//        "hcl",
//        "ecl",
//        "pid"
//    )
//
//    val passports = parseInput(input)
//
//    val fieldValidatedPassports = passports.filter { passport -> keys.all { passport.contains(it) } }
//
//    val splitPassports = fieldValidatedPassports.map { it.split(" ") }
//
//    val results = splitPassports.filter { pp -> pp.all { validateField(it) } }
//    println(results.count())
//}
//
//// parse the input, splitting the list when it detects a null line
//fun parseInput(input: List<String>): List<String> {
//    val passports: MutableList<String> = mutableListOf()
//    var passport = ""
//
//    input.forEach {
//        if(it.isNotBlank()) {
//            passport += (it + " ")
//        }
//        else {
//            passports.add(passport)
//            passport = ""
//        }
//    }
//    return passports
//}
//
//
//fun validateField(fieldString: String): Boolean {
//    if (fieldString.isBlank()) return true
//    val key = fieldString.split(":")[0]
//    val value = fieldString.split(":")[1]
//
//    return when(key){
//        "byr" -> {
//            value.toInt() in 1920..2002
//        }
//        "iyr" -> {
//            value.toInt() in 2010..2020
//        }
//        "eyr" -> {
//            value.toInt() in 2020..2030
//        }
//        "hgt" -> {
//            if (value.contains("cm")){
//                return value.filter { it.isDigit() }.toInt() in 150..193
//            } else if (value.contains("in")){
//                return value.filter { it.isDigit() }.toInt() in 59..76
//            } else {
//                false
//            }
//        }
//        "hcl" -> {
//            value.matches(Regex("#([0-f]{6})"))
//        }
//        "ecl" -> {
//            value in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
//        }
//        "pid" -> {
//            value.length == 9
//        }
//        "cid" -> true
//        else -> false
//    }
//}
//
