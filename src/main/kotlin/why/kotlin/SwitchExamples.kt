package why.kotlin

// Couple words on nullablility
var str1: String? = null
val str2: String? = "Hello Worlds"
val str: String = "null"

//val len = str2.length

val len = if (str2 != null) str2.length else 0

val len2 = str2?.length

val len3 = str2?.length ?: 0

val n = 2
val myNumber = when(n) {
    1 -> "One"
    2 -> "Two"
    else -> "Unknown number"
}

sealed class ChemicalElement(val atomicWeight: Int)
class H: ChemicalElement(1)
class He: ChemicalElement(2)
class Li: ChemicalElement(3)

fun elementName(element: ChemicalElement): String {
    return when(element) {
        is H -> "Hydrogen"
        is He -> "Helium"
        is Li -> "Lithium"
    }
}