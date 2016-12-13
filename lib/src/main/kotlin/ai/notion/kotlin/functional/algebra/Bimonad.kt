package ai.notion.kotlin.functional.algebra

interface Bimonad<A : Any> : Monad<A>, Comonad<A> {
}
