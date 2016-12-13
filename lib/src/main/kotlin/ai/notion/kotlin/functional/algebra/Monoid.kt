package ai.notion.kotlin.functional.algebra

interface Monoid<A : Any> : Semigroup<A> {

    interface Companion {

        fun <A : Monoid<*>> empty(): A

    }

}
