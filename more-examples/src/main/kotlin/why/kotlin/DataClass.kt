package why.kotlin

data class Person(val name: String, val age: Int)

// Effective java: item 7: Obey generate contract when overriding equals
// item 8: Always override hascode when you override equals
// item 9: Always override toString
fun main(args: Array<String>) {
    val person1 = Person("Alice", 25)
    val person2 = Person("Alice", 25)
    // equals/hashcode are compiler generated
    println(person1 == person2)
    // copy constructor + toString() method
    println(person1.copy(name = "Bob"))
    val (name, age) = person1
    // Component functions generated for data classes enable destructing
    println("name=$name and age=$age")
}

