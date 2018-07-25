package barista

import java.util.*

object VendingDisplay {
    private val scanner = Scanner(System.`in`)

    @JvmStatic
    fun main(args: Array<String>) {
        keepServing(CoffeeVendor)
    }

    private fun keepServing(vendor: CoffeeVendor) {
        while (true) {
            println("Make a choice for coffee 1. House Blend 2. Espresso - Any other key for exit")
            val choice = scanner.nextLine()
            if ("1" == choice.trim()) {
                val beverage = vendor.serveCoffee(CoffeeType.HOUSE_BLEND, milkNeeded(), syrupNeeded(), sugarNeeded())
                println("Serving ${beverage.description} Total cost = ${beverage.cost()}")
            } else if ("2" == choice.trim()) {
                val beverage = vendor.serveCoffee(CoffeeType.ESPRESSO, milkNeeded(), syrupNeeded(), sugarNeeded())
                println("Serving ${beverage.description} Total cost = ${beverage.cost()}")
            } else {
                println("Terminating...")
                System.exit(0)
            }
        }
    }

    private fun milkNeeded(): Boolean {
        println("Do you want to add milk? (y/n)")
        return "y" == scanner.nextLine().trim()
    }

    private fun syrupNeeded(): Boolean {
        println("Do you want to add flavored syrup? (y/n)")
        return "y" == scanner.nextLine().trim()
    }

    private fun sugarNeeded(): Boolean {
        println("Do you want to add sugar? (y/n)")
        return "y" == scanner.nextLine().trim()
    }
}