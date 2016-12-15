package ai.notion.kotlinz.algebra

interface Apply<A : Any> : Functor<A> {

    infix fun <B : Any> apply(k: Apply<(A) -> B>): Apply<B>

}
