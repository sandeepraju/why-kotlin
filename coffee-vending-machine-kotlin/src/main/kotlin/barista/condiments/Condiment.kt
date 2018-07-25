package barista.condiments

import barista.Beverage

abstract class Condiment : Beverage()

class Milk : Condiment() {
    override val description: String = "Milk"

    override fun cost(): Float = 0.5f
}

class Sugar : Condiment() {
    override val description: String = "Sugar"

    override fun cost(): Float = 0.1f
}

class FlavoredSyrup : Condiment() {
    override val description: String = "Flavored Syrup!"

    override fun cost(): Float = 0.3f
}

class CocoaPowder : Condiment() {
    override val description: String = "Cocoa Powder!"

    override fun cost(): Float = 0.4f
}