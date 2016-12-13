package ai.notion.kotlin.functional.algebra

interface Foldable<out A : Any> {

    fun <B : Any> reduce(initial: B, f: (B, A) -> B): B

}
