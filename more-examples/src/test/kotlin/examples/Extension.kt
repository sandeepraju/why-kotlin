package examples

fun String.removeFirstCharacter(): String {
    return this.substring(1)
}

fun main(args: Array<String>) {
    val input = "ABCDE"
    println("${input.removeFirstCharacter()}")
}