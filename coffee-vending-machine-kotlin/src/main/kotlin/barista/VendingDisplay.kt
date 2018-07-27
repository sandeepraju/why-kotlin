package barista

import org.jline.reader.LineReaderBuilder
import org.jline.terminal.TerminalBuilder

object VendingDisplay {
    // Note: Interop with Java jline library
    private val terminal = TerminalBuilder.builder().dumb(true).build()
    private val reader = LineReaderBuilder.builder().terminal(terminal).build()

    @JvmStatic
    fun main(args: Array<String>) {
        keepServing(CoffeeVendor)
    }

    private fun keepServing(vendor: CoffeeVendor) {
        // Note: Higher order functions
        val logCoffeePreparationTime = { time: Long ->
            println("It took $time ms to prepare this coffee!")
        }

        while (true) {
            try {
                val menu = CoffeeType.values().map { coffee ->
                    // No stream() and collect like java does
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
                val choice = CoffeeType.from(reader.readLine().trim())
                val beverages = vendor.serveCoffee(coffeeType = choice, hasMilk = milkNeeded(), hasSyrup = syrupNeeded(), hasSugar = sugarNeeded(), quantities = quantitiesNeeded(), metrics = logCoffeePreparationTime)
                // Higher order function
                println("Serving: ${choice.name} Total cost: ${"$"}${beverages.totalCost()}")
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
        return "y" == reader.readLine().trim().toLowerCase()
    }

    private fun syrupNeeded(): Boolean {
        println("Do you want to add flavored syrup? (y/n)")
        return "y" == reader.readLine().trim().toLowerCase()
    }

    private fun sugarNeeded(): Boolean {
        println("Do you want to add sugar? (y/n)")
        return "y" == reader.readLine().trim().toLowerCase()
    }

    private fun quantitiesNeeded(): Int {
        println("Total cups of coffee?")
        return Integer.parseInt(reader.readLine().trim())
    }
}
