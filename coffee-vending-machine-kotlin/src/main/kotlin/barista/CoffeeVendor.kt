package barista

object CoffeeVendor {
    fun serveCoffee(coffeeType: CoffeeType, hasMilk: Boolean? = null, hasSyrup: Boolean? = null, hasSugar: Boolean? = null): Beverage {
        return CoffeeFactory.getCoffee(coffeeType, hasMilk, hasSyrup, hasSugar)
    }
}