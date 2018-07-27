package barista

abstract class Beverage {
    abstract val description: String

    abstract fun cost(): Float
}

// Note: Extension function
fun List<Beverage>.totalCost(): Float {
    return this.fold(0.0f, { total, next -> total + next.cost() })
}