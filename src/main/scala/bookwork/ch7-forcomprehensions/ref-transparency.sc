// src/main/scala/bookwork/ch7-forcomprehensions/ref-transparency.sc

def addInts(s1: String, s2: String): Int =
  s1.toInt + s2.toInt

for {
  i <- 1 to 3
  j <- 1 to i
} println(s"$i+$j = ${addInts(i.toString, j.toString)}")


addInts("0", "x")
