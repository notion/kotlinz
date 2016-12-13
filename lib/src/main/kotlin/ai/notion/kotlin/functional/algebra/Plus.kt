package ai.notion.kotlin.functional.algebra

interface Plus<A : Any> : Alt<A> {

    interface Companion {

        fun <A : Any> zero(): Plus<A>

    }

}
