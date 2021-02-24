import java.util.*
import kotlin.random.Random

val valueRange = -999..999
val sizesRange = 5..300

val random = Random(Date().time)

fun main() {
    val scanner = Scanner(System.`in`)
    val size = scanner.nextInt()
    val arrays = generateRandomArraysAndSortByParity(size)

    arrays.forEach {
        printArray(it)
        println()
    }
}

fun generateRandomArraysAndSortByParity(arrayCount: Int): Array<Array<Int>> {
    val arrays = generateRandomArrays(arrayCount)
    sortArrays(arrays)
    return arrays
}

private fun generateRandomIntFromRange(range: IntRange): Int =
    random.nextInt(range.last - range.first + 1) + range.first

private fun generateRandomArray(size: Int): Array<Int> = Array(size) { generateRandomIntFromRange(valueRange) }

fun generateRandomArrays(arrayCount: Int): Array<Array<Int>> {
    if (arrayCount > sizesRange.last - sizesRange.first) {
        throw IllegalArgumentException("Range of sizes is too little")
    }

    val sizes: MutableSet<Int> = HashSet()

    return Array(arrayCount) {
        var size: Int
        do {
            size = generateRandomIntFromRange(sizesRange)
        } while (sizes.contains(size))

        sizes.add(size)

        generateRandomArray(size)
    }
}

private fun sortArrays(array: Array<Array<Int>>) {
    array.forEachIndexed{index, ints ->
        if (index % 2 == 0) {
            ints.sort()
        } else {
            ints.sortDescending()
        }
    }
}

private fun printArray(array: Array<Int>) {
    println("size: ${array.size}")
    array.forEach { print("$it ") }
    println()
}

