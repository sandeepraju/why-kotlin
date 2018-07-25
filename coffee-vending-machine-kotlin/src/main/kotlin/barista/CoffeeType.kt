package barista

enum class CoffeeType(val value: String) {
    ESPRESSO("1"),
    HOUSE_BLEND("2");

    companion object {
        private val map = CoffeeType.values().associateBy(CoffeeType::value)

        fun from(coffeeType: String) = map.getOrElse(coffeeType) {
            throw IllegalArgumentException("Invalid CoffeeType")
        }

    }
}
