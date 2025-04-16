package codes.romain.bootstrap.generator

private val numbers = mapOf(
    "0" to "zero",
    "1" to "one",
    "2" to "two",
    "3" to "three",
    "4" to "four",
    "5" to "five",
    "6" to "six",
    "7" to "seven",
    "8" to "eight",
    "9" to "nine"
)

fun uppercaseFirstLetter(word: String) = word.first().uppercase() + word.drop(1).lowercase()

fun generatePropertyName(iconName: String): String {
    val pieces = iconName.split("-")

    // special case handling of the first part
    val firstPiece = pieces.first().let {
        if (it.length == 1 && it[0].isDigit()) {
            numbers[it] ?: throw IllegalArgumentException("Unexpected digit value '$it'")
        } else {
            it
        }
    }

    return (listOf(firstPiece) + pieces.drop(1)).joinToString("") { it.first().uppercase() + it.drop(1).lowercase() }
}