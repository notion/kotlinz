package ai.notion.kotlin.functional.algebra

interface Apply<A : Any> : Functor<A> {

    infix fun <B : Any> apply(f: Apply<(A) -> B>): Apply<B>

}
