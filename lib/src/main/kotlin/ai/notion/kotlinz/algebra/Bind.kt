package ai.notion.kotlinz.algebra

interface Bind<A : Any> : Apply<A> {

	infix fun <B : Any> bind(f: (A) -> Bind<B>): Bind<B>

}
