package com.michaelpardo.monads.algebra

interface Monad<out A : Any> : Functor<A> {

	infix fun <T : Any> bind(f: (A) -> Monad<T>): Monad<T> // flatMap

	operator fun <T : Any> plus(f: (A) -> Monad<T>): Monad<T> = bind(f)

}
