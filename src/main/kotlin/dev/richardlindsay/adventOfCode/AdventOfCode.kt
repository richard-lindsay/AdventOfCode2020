package dev.richardlindsay.adventOfCode

fun main(){

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

class AdventOfCode {

}