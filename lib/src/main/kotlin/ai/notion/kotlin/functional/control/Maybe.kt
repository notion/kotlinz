package ai.notion.kotlin.functional.control

import ai.notion.kotlin.functional.algebra.Applicative
import ai.notion.kotlin.functional.algebra.Apply
import ai.notion.kotlin.functional.algebra.Functor
import ai.notion.kotlin.functional.algebra.Monad

sealed class Maybe<A : Any> : Monad<A>, Applicative<A> {

    class Nothing<A : Any> private constructor() : Maybe<A>() {

        override fun <B : Any> map(f: (A) -> B): Functor<B> = Nothing()

        override fun <B : Any> apply(f: Apply<(A) -> B>): Apply<B> = Nothing()

        override fun <B : Any> bind(f: (A) -> Monad<B>): Monad<B> = Nothing()

        override fun toString(): String = "[Nothing]"

        companion object {

            private val INSTANCE = Nothing<Any>()

            @Suppress("UNCHECKED_CAST")
            fun <A : Any> of(): Applicative<A> = INSTANCE as Nothing<A>

        }

    }

    class Just<A : Any>(val value: A) : Maybe<A>() {

        override fun <B : Any> map(f: (A) -> B): Functor<B> = Just(f(value))

        override fun <B : Any> apply(f: Apply<(A) -> B>): Apply<B> = when (f) {
            is Just -> Just(f.value(value))
            else -> Nothing.of()
        }

        override fun <B : Any> bind(f: (A) -> Monad<B>): Monad<B> = f(value)

    }

    companion object : Applicative.Companion {

        override fun <A : Any> of(value: A?): Applicative<A> = if (value == null) Nothing.of() else Just(value)

    }

}
