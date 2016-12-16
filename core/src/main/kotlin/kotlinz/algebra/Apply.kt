package kotlinz.algebra

interface Apply<A : Any> : Functor<A> {

	infix fun <B : Any> apply(a: Apply<(A) -> B>): Apply<B>

}
