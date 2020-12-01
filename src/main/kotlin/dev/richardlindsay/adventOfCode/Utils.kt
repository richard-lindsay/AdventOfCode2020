package dev.richardlindsay.adventOfCode

class Utils {

    fun loadFile(fileName: String): List<String> = this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()
}