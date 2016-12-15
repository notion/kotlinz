package kotlinz.algebra

interface Applicative<A : Any> : Apply<A> {

	interface Companion {

		fun <A : Any> of(value: A?): Applicative<A>

	}

}
