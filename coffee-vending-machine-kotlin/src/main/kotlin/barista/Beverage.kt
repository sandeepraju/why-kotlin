package barista

abstract class Beverage {
    abstract val description: String

    abstract fun cost(): Float
}