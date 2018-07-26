package examples

object Connection {
    private const val instance = "connection object"
    fun getConnection(): String {
        return instance
    }
}

fun main(args: Array<String>) {
    println("${Connection.getConnection()}")
}