package dev.richardlindsay.adventOfCode

class Utils {

    fun loadFile(fileName: String): List<String> = this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()

    fun printChristmas(){

        val baseLength = 100
        var starString = ""

        for (i in 0 .. baseLength/2 + 1) starString = starString.plus(" ")
        starString = starString.plus("*")

        val layers: MutableList<String> = mutableListOf(starString)

        for (i in 0 .. baseLength / 2) {
            var layerString = ""

            for (j in 0 .. baseLength/2 - i) layerString = layerString.plus(" ")
            for (j in 0 .. i ) layerString = layerString.plus("/")
            layerString = layerString.plus("|")
            for (j in 0 .. i ) layerString = layerString.plus("""\""")
            layers.add(layerString)
        }

        layers.forEach {
            println(it)
        }
    }
}