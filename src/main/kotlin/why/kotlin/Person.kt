package why.kotlin

data class Person(val name: String, val age: Int)

// In addition to all we implemented why.java.Person we also have
// componentN() functions implemented - allowing destructuring

fun printPerson(person: Person) {
    val (name, age) = person
    println("Person name is $name and age is $age")
}

// Also data class provides automatically generated copy() function that allows creating new objects
// partially based on existing objects
// Also notice use of named parameters
val youngPeson = Person("Jane", 3)
val olderPerson = youngPeson.copy(age = 5)