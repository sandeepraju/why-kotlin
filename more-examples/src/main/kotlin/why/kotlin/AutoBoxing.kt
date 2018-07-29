package why.kotlin


class Database {
    fun beginTransaction() = {}

    fun setTransactionSuccessful() = {}

    fun endTransaction() = {}

    fun deleteCustomer(): Int {
        return 1
    }
}


fun transaction(db: Database, body: (Database) -> Int): Int {
    db.beginTransaction()
    try {
        val result = body(db)
        db.setTransactionSuccessful()
        return result
    } finally {
        db.endTransaction()
    }
}

// Check decompile code to see: int result = ((Number)body.invoke(db)).intValue();
// A higher-order function will actually involve systematic boxing and unboxing when the function involves primitive types (like Int or Long) for input values or the return value
fun main(args: Array<String>) {
    transaction(Database()) { it.deleteCustomer() }
}