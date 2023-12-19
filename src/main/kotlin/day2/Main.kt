package day2

import java.io.File

fun main() {
    val input = File("src/main/kotlin/day2/Input.txt").readLines()
    val mySolution = MySolution(input)
    val result = mySolution.calculateGameIdSum()
    println(result)
}