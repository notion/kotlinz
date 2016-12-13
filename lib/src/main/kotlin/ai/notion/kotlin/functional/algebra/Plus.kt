package ai.notion.kotlin.functional.algebra

interface Plus<A : Any> : Alt<A> {

    fun zero(): Plus<A>

}
