package ai.notion.kotlin.functional.algebra

interface Profunctor<A : Any, out B : Any> : Functor<A> {

    fun <C : Any, D : Any> promap(f1: (C) -> A, f2: (B) -> D): Profunctor<C, D>

}
