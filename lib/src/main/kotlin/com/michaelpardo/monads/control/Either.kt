package com.michaelpardo.monads.control

import com.michaelpardo.monads.algebra.Monad

sealed class Either<A : Any, B : Any> : Monad<B> {

	class Left<A : Any, B : Any>(val value: A) : Either<A, B>() {

		override fun <T : Any> fmap(f: (B) -> T) = Left<A, T>(value)

		override fun <T : Any> bind(f: (B) -> Monad<T>) = Left<A, T>(value)

	}

	class Right<A : Any, B : Any>(val value: B) : Either<A, B>() {

		override fun <T : Any> fmap(f: (B) -> T) = Right<A, T>(f(value))

		override fun <T : Any> bind(f: (B) -> Monad<T>) = f(value)

	}

}
