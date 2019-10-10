package org.test

class RandomMonad<A>(val run: (RandGen) -> Pair<A, RandGen>) {
    fun <B>flatMap(f: (A) -> RandomMonad<B>): RandomMonad<B> {
        return RandomMonad {rnd ->
            val one = run(rnd)
            val two = f(one.first)
            two.run(one.second)
        }
    }

    fun <B> map(f: (A) -> B): RandomMonad<B> {
        return RandomMonad { rnd ->
            val one = run(rnd)
            val two = f(one.first)
            Pair(two, one.second)
        }
    }
}