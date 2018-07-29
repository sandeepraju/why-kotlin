package why.kotlin
// Effective java: Item 2: Enforce Singleton property with private constructor
object Connection {
    private const val instance = "connection object"
    fun getConnection(): String {
        return instance
    }
}

fun main(args: Array<String>) {
    println("${Connection.getConnection()}")
}