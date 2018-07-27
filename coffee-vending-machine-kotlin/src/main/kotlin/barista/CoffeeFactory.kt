package barista

import barista.coffee.Espresso
import barista.coffee.HouseBlend
import barista.condiments.FlavoredSyrup
import barista.condiments.Milk
import barista.condiments.Sugar

object CoffeeFactory {
    fun getCoffee(coffeeType: CoffeeType, hasMilk: Boolean?, hasSyrup: Boolean?, hasSugar: Boolean?, quantity: Int = 1): List<Beverage> {
        // Note: Compile time checking of all code branches
        return when (coffeeType) {
            CoffeeType.HOUSE_BLEND -> (1..quantity).map {
                HouseBlend(milk = hasMilk?.let { Milk() },
                        syrup = hasSyrup?.let { FlavoredSyrup() },
                        sugar = hasSugar?.let { Sugar() })
            }
            CoffeeType.ESPRESSO -> (1..quantity).map {
                Espresso(milk = hasMilk?.let { Milk() },
                        syrup = hasSyrup?.let { FlavoredSyrup() },
                        sugar = hasSugar?.let { Sugar() })
            }
        }
    }
}
