package ai.notion.kotlin.functional.algebra

interface Foldable<A : Any> {

    fun <B : Any> reduce(initial: B, f: (B, A) -> B): B

}
