// src/main/scala/bookwork/ch7-forcomprehensions/for-foreach.sc

val states = List("Alabama", "Alaska", "Virginia", "Wyoming")

for {
  s <- states
} println(s)

states foreach println
