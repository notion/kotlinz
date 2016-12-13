package ai.notion.kotlin.functional.algebra

interface Monoid<A : Any> : Semigroup<A> {

	fun empty(): A

}
