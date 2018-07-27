package barista

import java.util.*

object VendingDisplay {
    private val scanner = Scanner(System.`in`)

    @JvmStatic
    fun main(args: Array<String>) {
        keepServing(CoffeeVendor)
    }

    // TODO:
    // Java - kotlin interop using jline 3
    // Extension function
    // Immutable collections

    private fun keepServing(vendor: CoffeeVendor) {
        // Note: Higher order functions
        val logCoffeePrepartionTime = { time: Long ->  println("It took ${time}ms to prepare this coffee!") }

        while (true) {
            try {
                val menu = CoffeeType.values().map { coffee -> // No stream() and collect like java does
                    "${coffee.value} ${coffee.name
                        .replace("_", " ")
                        .toLowerCase()
                        .capitalize()}"
                }
                // Nice string manipulation
                println("""
                    |Make a choice for coffee:
                    |${menu.joinToString("\n")}
                    |Any other key for exit
                """.trimMargin())
                val choice = CoffeeType.from(scanner.nextLine().trim())
                val beverage = vendor.serveCoffee(choice, milkNeeded(), syrupNeeded(), sugarNeeded()) { logCoffeePrepartionTime }  // Higher order function
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
