package day2

class Part2(private val input: List<String>) {
    private var gamePowerSum = 0

    fun calculateGamePowerSum(): Int {
        input.forEach {
            val splittedGameIdAndSubsets = it.split(":")
            val subsets = splittedGameIdAndSubsets.last().split(";")

            gamePowerSum += getGameMinReqCubes(subsets)
        }
        return gamePowerSum
    }

    private fun getGameMinReqCubes(subsets: List<String>): Int {
        val cubeGame = CubeGame()

        subsets.forEach {
            val revealedCubes = it.split(",")
            val subsetCubes = getSubsetCubes(revealedCubes)

            cubeGame.redAmount = maxOf(cubeGame.redAmount, subsetCubes.redAmount)
            cubeGame.greenAmount = maxOf(cubeGame.greenAmount, subsetCubes.greenAmount)
            cubeGame.blueAmount = maxOf(cubeGame.blueAmount, subsetCubes.blueAmount)
        }


        return cubeGame.redAmount * cubeGame.greenAmount * cubeGame.blueAmount
    }

    private fun getSubsetCubes(revealedCubes: List<String>): CubeGame {
        val cubeGame = CubeGame()

        revealedCubes.forEach { revealedCube ->
            val cubeAmount = revealedCube.filter { it.isDigit() }.toInt()

            when {
                revealedCube.contains("red") -> cubeGame.redAmount = cubeAmount
                revealedCube.contains("green") -> cubeGame.greenAmount = cubeAmount
                revealedCube.contains("blue") -> cubeGame.blueAmount = cubeAmount
            }
        }
        return cubeGame
    }
}