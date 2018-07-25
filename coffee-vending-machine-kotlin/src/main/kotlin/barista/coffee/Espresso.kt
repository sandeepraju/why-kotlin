package barista.coffee

import barista.Beverage
import barista.condiments.FlavoredSyrup
import barista.condiments.Milk
import barista.condiments.Sugar

data class Espresso(private val milk: Milk? = null, private val sugar: Sugar? = null, private val syrup: FlavoredSyrup? = null) : Beverage() {
    override val description: String = "Espresso"

    override fun cost(): Float {
        var total = 3.50f
        milk?.let { total += it.cost() }
        sugar?.let { total += it.cost() }
        syrup?.let { total += it.cost() }
        return total
    }
}