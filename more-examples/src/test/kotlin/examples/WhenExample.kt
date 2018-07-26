package examples

sealed class Animal
class Dog(val name: String) : Animal()
class Cat(val name: String) : Animal()

fun main(args: Array<String>) {
    val animal = Dog("goofy")
    checkAnimal(animal)
}

fun checkAnimal(animal: Animal) = when(animal){
    // Required to cover all branches at compile time
    is Cat -> println("Found Cat!")
    is Dog -> println("Found Dog!")
}

