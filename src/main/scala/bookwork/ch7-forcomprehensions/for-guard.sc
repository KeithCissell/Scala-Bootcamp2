// src/main/scala/bookwork/ch7-forcomprehensions/for-guard.sc

val states = List("Alabama", "Alaska", "Virginia", "Wyoming")

for {
  s <- states
  c <- s
  if c.isLower
} yield s"$c-${c.toUpper}"
// Results: List("l-L", "a-A", ....)

states flatMap(_.toSeq withFilter (_.isLower) map (c => s"$c-${c.toUpper}"))
