package ai.notion.kotlinz.algebra

interface   Monad<A : Any> : Applicative<A>, Bind<A>
