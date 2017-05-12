// src/main/scala/bookwork/ch7-forcomprehensions/for-map.sc

val states = List("Alabama", "Alaska", "Virginia", "Wyoming")

for {
  s <- states
} yield s.toUpperCase

states map (_.toUpperCase)
