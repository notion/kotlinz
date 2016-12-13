package ai.notion.kotlin.functional.algebra

interface Chain<A : Any> : Apply<A> {

    infix fun <B : Any> chain(f: (A) -> Chain<B>): Chain<B>

}
