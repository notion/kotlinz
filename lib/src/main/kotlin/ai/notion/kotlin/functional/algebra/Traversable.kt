package ai.notion.kotlin.functional.algebra

interface Traversable<A : Any> : Functor<A>, Foldable<A> {
}
