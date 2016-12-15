package ai.notion.kotlinz.control

import ai.notion.kotlinz.algebra.Applicative
import ai.notion.kotlinz.algebra.Apply
import ai.notion.kotlinz.algebra.Bind
import ai.notion.kotlinz.algebra.Functor
import ai.notion.kotlinz.algebra.Monad

sealed class Maybe<A : Any> : Monad<A> {

	fun <B : Any> cata(f: (A) -> B, b: () -> B): B = when (this) {
		is Just -> f(value)
		is Empty -> b()
	}

	fun getOrElse(f: () -> A): A = cata(identity(), f)

	fun isJust(): Boolean = cata({ true }, { false })

	fun isEmpty(): Boolean = cata({ false }, { true })

	class Empty<A : Any> private constructor() : Maybe<A>() {

		override fun <B : Any> apply(f: Apply<(A) -> B>) = Maybe.Empty<B>()

		override fun <B : Any> bind(f: (A) -> Bind<B>) = Maybe.Empty<B>()

		override fun <B : Any> map(f: (A) -> B) = Maybe.Empty<B>()

		companion object {

			private val INSTANCE = Maybe.Empty<Any>()

			@Suppress("UNCHECKED_CAST")
			fun <A : Any> of(): Maybe<A> = INSTANCE as Maybe.Empty<A>

		}

	}

	class Just<A : Any>(val value: A) : Maybe<A>() {

		override fun <B : Any> apply(a: Apply<(A) -> B>): Apply<B> = when (a) {
			is Maybe.Just -> Maybe.Just(a.value(value))
			else -> Maybe.Empty.Companion.of()
		}

		override fun <B : Any> map(f: (A) -> B): Functor<B> = bind { Maybe.Companion.of(f(it)) }

		override fun <B : Any> bind(f: (A) -> Bind<B>): Bind<B> = f(value)

	}

	companion object : Applicative.Companion {

		override fun <A : Any> of(value: A?): Maybe<A> = if (value == null) Maybe.Empty.Companion.of()
		else Maybe.Just(
				value)

	}

}
