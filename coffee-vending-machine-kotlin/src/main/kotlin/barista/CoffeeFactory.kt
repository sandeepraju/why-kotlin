package barista

import barista.coffee.Espresso
import barista.coffee.HouseBlend
import barista.condiments.FlavoredSyrup
import barista.condiments.Milk
import barista.condiments.Sugar

object CoffeeFactory {
    fun getCoffee(coffeeType: CoffeeType, hasMilk: Boolean?, hasSyrup: Boolean?, hasSugar: Boolean?): Beverage {
        return when (coffeeType) {
            CoffeeType.HOUSE_BLEND -> HouseBlend(milk = hasMilk?.let { Milk() },
                    syrup = hasSyrup?.let { FlavoredSyrup() },
                    sugar = hasSugar?.let { Sugar() })
            CoffeeType.ESPRESSO -> Espresso(milk = hasMilk?.let { Milk() },
                    syrup = hasSyrup?.let { FlavoredSyrup() },
                    sugar = hasSugar?.let { Sugar() })
        }
    }
}