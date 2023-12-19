package day1

import java.io.File

fun main() {
    val input = File("src/main/kotlin/day1/Input.txt").readLines()
    val mySolution = MySolution(input)
    val result = mySolution.calculateCodeSum()
    println(result)
}