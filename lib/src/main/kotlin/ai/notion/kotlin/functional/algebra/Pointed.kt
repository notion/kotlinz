package ai.notion.kotlin.functional.algebra

interface Pointed<A : Any> {

    fun pure(value: A): A

}
