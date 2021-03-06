package kotlinz

infix fun <A, B, C> ((B) -> C).compose(f: (A) -> B): ((A) -> C) = { a: A -> this(f(a)) }

infix fun <A, B, C> ((A) -> B).forwardCompose(f: (B) -> C): ((A) -> C) = { a: A -> f(this(a)) }
