package y2025.day01

import println
import readInput
import kotlin.math.absoluteValue

private val clazz = object{}.javaClass

fun main() {

    fun part1(input: List<String>): Int {
        var dial = 50
        var matches = 0
        input.forEach {
            dial = moveDial(dial, it)
            if (dial % 100 == 0) {
                matches++
            }
        }

        return matches
    }

    fun part2(input: List<String>): Int {
        var dial = 50
        var matches = 0
        input.forEach {
            val result = moveDial2(dial, it)
            dial = result.first
            matches += result.second
        }

        return matches
    }

    // 1071
    val input1 = readInput(clazz, "InputData.txt")
    val result1 = part1(input1)
    result1.println()
    check(result1 == 1071)
    
    // 6700
    val input2 = readInput(clazz, "InputData.txt")
    val result2 = part2(input2)
    result2.println()
    check(result2 == 6700)
}

fun moveDial(dial: Int, rotation: String): Int {
    val direction = rotation.first()
    val rotationNumber = rotation.drop(1).toInt()

    return when(direction) {
        'L' -> dial - rotationNumber
        'R' -> dial + rotationNumber
        else -> dial
    }
}

fun moveDial2(dial: Int, rotation: String): Pair<Int, Int> {
    val direction = rotation.first()
    val rotationNumber = rotation.drop(1).toInt()

    return when(direction) {
        'L' -> moveDialLeft(dial, rotationNumber)
        'R' -> moveDialRight(dial, rotationNumber)
        else -> Pair(dial, 0)
    }
}

fun moveDialLeft(dial: Int, rotationNumber: Int): Pair<Int, Int> {
    val modRotationNumber = rotationNumber.mod(100)
    val newDial = (dial - modRotationNumber)
    var numberOfWraps = Math.floorDiv(rotationNumber, 100)
    if (dial > 0 && newDial <= 0) {
        numberOfWraps++
    }

    return Pair(newDial.mod(100), numberOfWraps)
}

fun moveDialRight(dial: Int, rotationNumber: Int): Pair<Int, Int> {
    val newDial = (dial + rotationNumber)
    val numberOfWraps = Math.floorDiv(newDial.absoluteValue, 100)

    return Pair(newDial.mod(100), numberOfWraps)
}