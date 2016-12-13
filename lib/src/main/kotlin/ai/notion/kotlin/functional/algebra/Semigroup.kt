package ai.notion.kotlin.functional.algebra

interface Semigroup<A : Any> {

    infix fun concat(value: Semigroup<A>): Semigroup<A>

}
