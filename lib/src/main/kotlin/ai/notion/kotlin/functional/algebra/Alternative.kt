package ai.notion.kotlin.functional.algebra

interface Alternative<A : Any> : Applicative<A>, Plus<A>
