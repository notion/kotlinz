package ai.notion.kotlin.functional.algebra

interface Traversable<out A : Any> : Functor<A>, Foldable<A> {

    fun <B : Any, C : Any> traverse(f: (A) -> Applicative<B>, of: (C) -> Applicative<C>): Applicative<Traversable<B>>

}
