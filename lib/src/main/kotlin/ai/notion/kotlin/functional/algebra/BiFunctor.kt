package ai.notion.kotlin.functional.algebra

interface Bifunctor<out A : Any, out B : Any> : Functor<A> {

    fun <C : Any, D : Any> bimap(f1: (A) -> C, f2: (B) -> D): Bifunctor<C, D>

}
