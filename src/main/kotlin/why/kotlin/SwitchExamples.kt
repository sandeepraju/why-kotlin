package why.kotlin

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