package org.test

import kotlin.random.Random

fun runGen(seed: Long): Long {
    val rnd = Random(seed)
    return rnd.nextLong()
}

fun main() {
    println(runGen(System.currentTimeMillis()))
    println(RandGen(System.currentTimeMillis()).nextValue())
    val bla: RandomMonad<Long> = RandomMonad {rnd -> rnd.nextValue()}
    val result1 = bla.flatMap(f)
    println(result1.run(RandGen(1L/*System.currentTimeMillis()*/)).first)
    val result2 = result1.flatMap(fBack)
    val result2Map = result1.map(fBack1)
    println(result2.run(RandGen(1L/*System.currentTimeMillis()*/)).first)
    println(result2Map.run(RandGen(1L)).first)

    val result3: RandomMonad<List<Long>> = RandomMonad { rnd -> Pair(listOf<Long>(), rnd) }
    val result4 = result3.flatMap(addToList).flatMap(addToList).flatMap(addToList)
    println(result4.run(RandGen(1L/*(System.currentTimeMillis())*/)).first)

    val bla1: RandomMonad<Long> = RandomMonad {rnd -> rnd.nextValue()}
    println(bla1.map(f1).run(RandGen(1L /*System.currentTimeMillis()*/)).first)

    println(RandGen(1L).nextValue())
    println(RandGen(1L).nextValue())

    println("-------------------------------------")

    val run1: (RandGen) -> Pair<Long, RandGen> = { rnd ->
        rnd.nextValue()
    }
    val initial = RandomMonad (run1)
    println("Initial Result: ${initial.run(RandGen(1L)).first}")
    val summered = initial.flatMap(addToRandom)
    println("Sum Result: ${summered.run(RandGen(1L)).first}")

    println("-----------------------------------")
    val generator = Random(1L)
    val rand = generator.nextLong()
    val rand2  = generator.nextLong()
    println(rand)
    println(rand2)
}

class RandGen(private val seed: Long) {
    fun nextValue(): Pair<Long, RandGen> {
        val nextLong = Random(seed).nextLong()
        return (nextLong to RandGen(nextLong))
    }
}

val f: (Long) -> RandomMonad<String> = {a -> RandomMonad { rnd -> Pair(a.toString(), rnd) } }
val f1: (Long) -> String = {a -> a.toString()}
val fBack: (String) -> RandomMonad<Long> = {str -> RandomMonad {rnd -> Pair(str.toLong(), rnd)} }
val fBack1: (String) -> Long = {str -> str.toLong()}
val addToList: (List<Long>) -> RandomMonad<List<Long>> = {
        list -> RandomMonad { rnd ->
    val next = rnd.nextValue()
    Pair(list + next.first, next.second)
}

}

val addToRandom: (Long) -> RandomMonad<Long> = {a -> RandomMonad { rnd ->
    val next = rnd.nextValue()
    Pair(next.first + a, next.second)
}
}

val rand = Random(1L).nextLong()
//2577512651365090736
