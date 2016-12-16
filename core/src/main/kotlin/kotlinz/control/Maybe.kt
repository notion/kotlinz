package kotlinz.control

import kotlinz.algebra.Applicative
import kotlinz.algebra.Apply
import kotlinz.algebra.Bind
import kotlinz.algebra.Functor
import kotlinz.algebra.Monad

sealed class Maybe<A : Any> : Monad<A> {

	fun <B : Any> cata(f: (A) -> B, b: () -> B): B = when (this) {
		is Just -> f(value)
		is Empty -> b()
	}

	fun getOrElse(f: () -> A): A = cata(identity(), f)

	fun isJust(): Boolean = cata({ true }, { false })

	fun isEmpty(): Boolean = cata({ false }, { true })

	class Empty<A : Any> private constructor() : Maybe<A>() {

		override fun <B : Any> map(f: (A) -> B): Maybe<B> = Empty()

		override fun <B : Any> apply(a: Apply<(A) -> B>): Maybe<B> = Empty()

		override fun <B : Any> bind(f: (A) -> Bind<B>): Maybe<B> = Empty()

		companion object {

			private val INSTANCE = Empty<Any>()

			@Suppress("UNCHECKED_CAST")
			fun <A : Any> of(): Maybe<A> = INSTANCE as Empty<A>

		}

	}

	class Just<A : Any>(val value: A) : Maybe<A>() {

		override fun <B : Any> map(f: (A) -> B): Functor<B> = bind { Maybe.of(f(it)) }

		override fun <B : Any> apply(a: Apply<(A) -> B>): Maybe<B> = when (a) {
			is Just -> Just(a.value(value))
			else -> Empty.of()
		}

		override fun <B : Any> bind(f: (A) -> Bind<B>): Bind<B> = f(value)

	}

	companion object : Applicative.Companion {

		override fun <A : Any> of(value: A?): Maybe<A> = if (value == null) Empty.of() else Just(value)

	}

}
