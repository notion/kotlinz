package kotlinz.control

import kotlinz.algebra.Apply
import kotlinz.algebra.Bind
import kotlinz.algebra.Monad
import kotlinz.control.Maybe.Empty

sealed class Either<A : Any, B : Any> : Monad<B> {

	abstract operator fun component1(): Maybe<A>
	abstract operator fun component2(): Maybe<B>
	abstract fun left(): Maybe<A>
	abstract fun right(): Maybe<B>

	fun <C : Any> cata(f: (B) -> C, c: () -> C): C = when (this) {
		is Left -> c()
		is Right -> f(value)
	}

	fun isLeft() = cata({ true }, { false })

	fun isRight() = cata({ false }, { true })

	fun swap() = cata({ right() }, { left() })

	class Left<A : Any, B : Any>(val value: A) : Either<A, B>() {

		override fun component1(): Maybe<A> = left()

		override fun component2(): Maybe<B> = right()

		override fun left(): Maybe<A> = Maybe.of(value)

		override fun right(): Maybe<B> = Empty.of()

		override fun <C : Any> map(f: (B) -> C): Either<A, C> = Left(value)

		override fun <C : Any> apply(a: Apply<(B) -> C>): Either<A, C> = Left(value)

		override fun <C : Any> bind(f: (B) -> Bind<C>): Either<A, C> = Left(value)

	}

	class Right<A : Any, B : Any>(val value: B) : Either<A, B>() {

		override fun component1(): Maybe<A> = left()

		override fun component2(): Maybe<B> = right()

		override fun left(): Maybe<A> = Empty.of()

		override fun right(): Maybe<B> = Maybe.of(value)

		override fun <C : Any> map(f: (B) -> C): Either<A, C> = Right(f(value))

		override fun <C : Any> apply(a: Apply<(B) -> C>): Either<A, C> = TODO()

		override fun <C : Any> bind(f: (B) -> Bind<C>): Either<A, C> = TODO()

	}

	companion object {

		fun <A : Any, B : Any> ofLeft(value: A): Either<A, B> = Left(value)

		fun <A : Any, B : Any> ofRight(value: B): Either<A, B> = Right(value)

	}

}
