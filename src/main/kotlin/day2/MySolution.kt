package day2

class MySolution(private val input: List<String>) {
    private val maxRed = 12
    private val maxGreen = 13
    private val maxBlue = 14
    private var validGameIdSum = 0

    fun calculateGameIdSum(): Int {
        for (line in input) {
            val splittedGameIdAndSubsets = line.split(":")
            val gameId = splittedGameIdAndSubsets.first()
                .filter { it.isDigit() }.toInt()
            val subsets = splittedGameIdAndSubsets.last().split(";")

            if(isGameValid(subsets)) {
                validGameIdSum += gameId
            }
        }
        return validGameIdSum
    }

    private fun isGameValid(subsets: List<String>): Boolean {
        for (subset in subsets) {
            val cubeGame = CubeGame()
            val revealedCubes = subset.split(",")

            if (!isSubsetValid(revealedCubes, cubeGame)) return false
        }
        return true
    }

    private fun isSubsetValid(revealedCubes: List<String>, cubeGame: CubeGame): Boolean {
        for (revealedCube in revealedCubes) {
            when {
                revealedCube.contains("red") -> cubeGame.redAmount += revealedCube.filter { it.isDigit() }.toInt()
                revealedCube.contains("green") -> cubeGame.greenAmount += revealedCube.filter { it.isDigit() }.toInt()
                revealedCube.contains("blue") -> cubeGame.blueAmount += revealedCube.filter { it.isDigit() }.toInt()
            }
        }
        return (cubeGame.redAmount <= maxRed &&
                cubeGame.greenAmount <= maxGreen &&
                cubeGame.blueAmount <= maxBlue)
    }
}