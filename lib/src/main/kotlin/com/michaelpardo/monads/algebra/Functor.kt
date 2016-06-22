package com.michaelpardo.monads.algebra

interface Functor<out A : Any> {

	infix fun <T : Any> fmap(f: (A) -> T): Functor<T> // map

}
