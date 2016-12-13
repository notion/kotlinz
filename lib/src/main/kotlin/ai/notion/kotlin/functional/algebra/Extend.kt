package ai.notion.kotlin.functional.algebra

interface Extend<A : Any> : Functor<A> {

    infix fun <B : Any> extend(f: (Extend<A>) -> B): Extend<B>

}
