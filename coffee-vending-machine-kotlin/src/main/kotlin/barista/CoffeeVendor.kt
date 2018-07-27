package barista

object CoffeeVendor {
    fun serveCoffee(coffeeType: CoffeeType, hasMilk: Boolean? = null, hasSyrup: Boolean? = null, hasSugar: Boolean? = null, metrics: (time: Long) -> Unit = {}): Beverage {
        val (result, time) = measureTime {          // Note: Deconstruction to variables
            CoffeeFactory.getCoffee(coffeeType, hasMilk, hasSyrup, hasSugar)
        }

        metrics(time)
        return result
    }
}

// Note: we can also nest this function
fun <T> measureTime(f: ()-> T): Pair<T, Long> {
    val startTime = System.currentTimeMillis()
    val result = f()
    return Pair(result, System.currentTimeMillis() - startTime)
}