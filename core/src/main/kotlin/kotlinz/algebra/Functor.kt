package kotlinz.algebra

interface Functor<A : Any> {

	fun identity() = { a: A -> a }

	infix fun <B : Any> map(f: (A) -> B): Functor<B>

}
