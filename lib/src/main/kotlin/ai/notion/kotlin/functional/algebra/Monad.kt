package ai.notion.kotlin.functional.algebra

interface Monad<A : Any> : Applicative<A>, Chain<A> {

    infix fun <B : Any> bind(f: (A) -> Monad<B>): Monad<B>

}
