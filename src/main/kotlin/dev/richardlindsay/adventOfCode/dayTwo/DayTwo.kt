package dev.richardlindsay.adventOfCode.dayTwo

import dev.richardlindsay.adventOfCode.Solution

data class Password(
    val char: Char,
    val min: Int,
    val max: Int,
    val value: String
)

class DayTwo: Solution() {
    override fun partOne(input: List<String>) {
        val validPasswords = input.filter {
            validatePasswordDayOne(parsePassword(it) )
        }.count()

        assert(validPasswords == 572)
        println("Day 2 Part 1 Result: $validPasswords")
    }

    override fun partTwo(input: List<String>) {
        val validPasswords = input.filter {
            validatePasswordDayTwo(parsePassword(it))
        }.count()

        assert(validPasswords == 306)
        println("Day 2 Part 2 Result: $validPasswords")
    }


    fun parsePassword(input: String): Password{
        val password = input.split(":")[1].trim()
        val rules = input.split(":")[0]
        val min = rules.split("-")[0].toInt()
        val max = rules.split("-")[1].split(" ")[0].toInt()
        val char = rules.last()

        return Password(char, min, max, password)
    }

    fun validatePasswordDayOne(password: Password): Boolean {
        val numberOfChars = password.value.filter { it == password.char}.count()
        return (numberOfChars >= password.min && numberOfChars <= password.max)
    }

    fun validatePasswordDayTwo(password: Password): Boolean {
        val charAtMin = password.value.getOrNull(password.min - 1)
        val charAtMax = password.value.getOrNull(password.max - 1)
        return (charAtMax == password.char).xor(charAtMin == password.char)
    }
}
//
//
//fun main(){
//    val input = utils.loadFile("/dayTwo/dayTwoInput.txt")
//    dayTwoPartOne(input)
//    dayTwoPartTwo(input)
//}
//
//fun dayTwoPartOne(input: List<String>){
//    val validPasswords = input.filter {
//        validatePasswordDayOne(parsePassword(it) )
//    }.count()
//
//    println(validPasswords)
//}
//
//fun dayTwoPartTwo(input: List<String>){
//    val validPasswords = input.filter {
//        validatePasswordDayTwo(parsePassword(it))
//    }.count()
//
//    println(validPasswords)
//}

//
//fun parsePassword(input: String): Password{
//    val password = input.split(":")[1].trim()
//    val rules = input.split(":")[0]
//    val min = rules.split("-")[0].toInt()
//    val max = rules.split("-")[1].split(" ")[0].toInt()
//    val char = rules.last()
//
//    return Password(char, min, max, password)
//}
//
//fun validatePasswordDayOne(password: Password): Boolean {
//    val numberOfChars = password.value.filter { it == password.char}.count()
//    return (numberOfChars >= password.min && numberOfChars <= password.max)
//}
//
//fun validatePasswordDayTwo(password: Password): Boolean {
//    val charAtMin = password.value.getOrNull(password.min - 1)
//    val charAtMax = password.value.getOrNull(password.max - 1)
//    return (charAtMax == password.char).xor(charAtMin == password.char)
//}
