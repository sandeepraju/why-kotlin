package examples

class Address {
    val street: String = "Main st" // read only property
    var city: String = "San Fransisco" // read/write property
    var state: String? = "CA"
}


// Lateinit property - can be used when
// doing DI or in setup of test method
private lateinit var dummyAddress: Address

fun main(args: Array<String>) {
    val address = Address()
    address.city = "San Jose" // direct set

    dummyAddress = Address()
    println(dummyAddress.city)
}
