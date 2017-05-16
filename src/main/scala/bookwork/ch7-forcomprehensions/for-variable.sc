// src/main/scala/bookwork/ch7-forcomprehensions/for-variable.sc

val states = List("Alabama", "Alaska", "Virginia", "Wyoming")

for {
  s <- states
  c <- s
  if c.isLower
  c2 = s"$c-${c.toUpper}"
} yield c2
// Results: List("l-L", "a-A", ....)

states flatMap (_.toSeq withFilter (_.isLower) map { c =>
  val c2 = s"$c-${c.toUpper}"
  c2
})
