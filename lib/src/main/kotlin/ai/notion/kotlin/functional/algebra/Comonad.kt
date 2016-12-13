package ai.notion.kotlin.functional.algebra

interface Comonad<A : Any> : Extend<A>, CoflatMap<A> {
}
