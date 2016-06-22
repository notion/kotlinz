package com.michaelpardo.monads.control

import com.michaelpardo.monads.algebra.Monad

sealed class Either<A : Any, B : Any> : Monad<B> {

	abstract val isLeft: Boolean
	abstract val isRight: Boolean

	abstract fun <C : Any> mapLeft(f: (A) -> C): Either<C, B>

	abstract fun <C : Any> mapRight(f: (B) -> C): Either<A, C>

	class Left<A : Any, B : Any>(val value: A) : Either<A, B>() {

		override val isLeft = true

		override val isRight = false

		override fun <C : Any> fmap(f: (B) -> C) = Left<A, C>(value)

		override fun <C : Any> bind(f: (B) -> Monad<C>) = Left<A, C>(value)

		override fun <C : Any> mapLeft(f: (A) -> C) = Left<C, B>(f(value))

		override fun <C : Any> mapRight(f: (B) -> C) = Left<A, C>(value)

	}

	class Right<A : Any, B : Any>(val value: B) : Either<A, B>() {

		override val isLeft = false

		override val isRight = true

		override fun <C : Any> fmap(f: (B) -> C) = Right<A, C>(f(value))

		override fun <C : Any> bind(f: (B) -> Monad<C>) = f(value)

		override fun <C : Any> mapLeft(f: (A) -> C) = Right<C, B>(value)

		override fun <C : Any> mapRight(f: (B) -> C) = Right<A, C>(f(value))

	}

}
