package day1

import java.io.File

fun main() {
    val input = File("src/main/kotlin/day1/Input.txt").readLines()
    val mySolution = MySolution()
    val result = mySolution.calculateCodeSum(input)
    println(result)
}