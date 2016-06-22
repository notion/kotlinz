package com.michaelpardo.monads.algebra

interface Monoid<A : Any> {

	fun zero(): A

	fun combine(a1: A, a2: A): A

}
