package examples

//Effective Java Item 2: Consider a builder when faced with many constructor parameters
//But Kotlin has “Named constructor parameters with default values”
//It’s shorter, cleaner and no issue with concurrence

data class Box(val height: Int = 10, val width: Int = 5, val breadth: Int = 8)

fun main(args: Array<String>) {
    println("Default box = ${Box()}")
    println("Box with different height = ${Box(height = 20)}")
    println("Box with different width and breadth = ${Box(width = 10, breadth = 6)}")
}