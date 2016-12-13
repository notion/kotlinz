package ai.notion.kotlin.functional.algebra

interface Functor<out A : Any> {

    infix fun <B : Any> map(f: (A) -> B): Functor<B>

}
