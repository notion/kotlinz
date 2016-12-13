package ai.notion.kotlin.functional.algebra

interface MonadCombile<A : Any> : MonadFilter<A>, Alternative<A> {
}
