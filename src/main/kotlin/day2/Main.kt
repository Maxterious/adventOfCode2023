package day2

import java.io.File

fun main() {
    val input = File("src/main/kotlin/day2/Input.txt").readLines()
//    val part1 = Part1(input)
//    val result = part1.calculateGameIdSum()
    val part2 = Part2(input)
    val result = part2.calculateGamePowerSum()
    println(result)
}