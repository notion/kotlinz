package ai.notion.kotlin.functional.algebra

interface Alt<A : Any> {

    infix fun alt(value: Alt<A>): Alt<A>

}
