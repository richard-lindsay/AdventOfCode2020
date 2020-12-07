package dev.richardlindsay.adventOfCode.daySix

import dev.richardlindsay.adventOfCode.Solution

class DaySix: Solution() {
    override fun partOne(input: List<String>) {
        val parsedInput = parseInputAsString(input)

        val inputSets = parsedInput.map { it.toSet() }

        val result = inputSets.flatten().count()

        assert(result == 6782)
        println("Day 6 Part 1 Result: $result")
    }

    override fun partTwo(input: List<String>) {
        val parsedInput = parseInputAsList(input)

        val result = parsedInput
            .map { list -> list.map { it.toList() }.reduce {acc, str -> acc.intersect(str).toList()}}
            .reduce { acc, it -> acc + it }.count()

        assert(result == 3596)

        println("Day 6 Part 2 Result: $result")

    }

    // Remove line breaks and group inputs together
    fun parseInputAsString(input: List<String>): List<String> {
        val chunks: MutableList<String> = mutableListOf()
        var chunk = ""

        input.forEach {
            if (it.isNotBlank()) chunk += (it)
            else {
                chunks.add(chunk)
                chunk = ""
            }
        }
        return chunks
    }

    fun parseInputAsList(input: List<String>): List<List<String>> {
        val chunks: MutableList<MutableList<String>> = mutableListOf()
        var chunk: MutableList<String> = mutableListOf()

        input.forEach {
            if (it.isNotBlank()) chunk.add(it)
            else {
                chunks.add(chunk)
                chunk = mutableListOf()
            }
        }
        return chunks
    }
}
