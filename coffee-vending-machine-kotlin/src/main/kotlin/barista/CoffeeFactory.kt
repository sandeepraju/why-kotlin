package barista

import barista.coffee.Espresso
import barista.coffee.HouseBlend
import barista.condiments.FlavoredSyrup
import barista.condiments.Milk
import barista.condiments.Sugar

object CoffeeFactory {
    fun getCoffee(coffeeType: CoffeeType, hasMilk: Boolean?, hasSyrup: Boolean?, hasSugar: Boolean?): Beverage {
        // Note: Compile time checking of all code branches
        return when (coffeeType) {
            CoffeeType.HOUSE_BLEND -> HouseBlend(milk = hasMilk?.let { Milk() },
                    syrup = hasSyrup?.let { FlavoredSyrup() },
                    sugar = hasSugar?.let { Sugar() })
            CoffeeType.ESPRESSO -> Espresso(milk = hasMilk?.let { Milk() },
                    syrup = hasSyrup?.let { FlavoredSyrup() },
                    sugar = hasSugar?.let { Sugar() })
        }
    }

    fun getNewCoffee(type: CoffeeType = CoffeeType.ESPRESSO, milk: Milk? = null, syrup: FlavoredSyrup? = null, sugar: Sugar? = null) {
        // Note: Compile time checking of all code branches
        with(type){
            ESPRESSO -> {}
        }
    }

}
