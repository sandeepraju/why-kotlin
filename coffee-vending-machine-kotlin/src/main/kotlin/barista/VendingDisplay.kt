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
            try {
                val menu = CoffeeType.values().map { coffee ->
                    "${coffee.value} ${coffee.name
                        .replace("_", " ")
                        .toLowerCase()
                        .capitalize()}"
                }
                println("""
                    |Make a choice for coffee:
                    |${menu.joinToString("\n")}
                    |Any other key for exit
                """.trimMargin())
                val choice = CoffeeType.from(scanner.nextLine().trim())
                val beverage = vendor.serveCoffee(choice, milkNeeded(), syrupNeeded(), sugarNeeded())
                println("Serving: ${beverage.description} Total cost: ${"$"}${beverage.cost()}")
                println("-".repeat(40))
                Thread.sleep(1000L)
            } catch (e: Exception) {
                println("Terminating...")
                e.printStackTrace()
                System.exit(0)
            }
        }
    }

    private fun milkNeeded(): Boolean {
        println("Do you want to add milk? (y/n)")
        return "y" == scanner.nextLine().toLowerCase().trim()
    }

    private fun syrupNeeded(): Boolean {
        println("Do you want to add flavored syrup? (y/n)")
        return "y" == scanner.nextLine().toLowerCase().trim()
    }

    private fun sugarNeeded(): Boolean {
        println("Do you want to add sugar? (y/n)")
        return "y" == scanner.nextLine().toLowerCase().trim()
    }
}
