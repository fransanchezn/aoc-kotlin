package y2025.day01

import println
import readInput

private val clazz = object{}.javaClass

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/InputData_test.txt` file:
    val testInput = readInput(clazz, "InputData_test.txt")
    check(part1(testInput) == 1)

    // Read the input from the `src/InputData.txt` file.
    val input = readInput(clazz, "InputData.txt")
    part1(input).println()
    part2(input).println()
}
