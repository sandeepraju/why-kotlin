package examples

import java.lang.Integer.parseInt

fun main(args: Array<String>) {
    val input = "test"
    val a: Int? = try { parseInt(input) } catch (e: NumberFormatException) { null }
    println(a)
}