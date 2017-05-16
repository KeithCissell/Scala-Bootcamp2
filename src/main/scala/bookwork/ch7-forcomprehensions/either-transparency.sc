// src/main/scala/bookwork/ch7-forcomprehensions/either-transparency.sc

def addInts2(s1: String, s2: String): Either[NumberFormatException,Int] =
  try {
    Right(s1.toInt + s2.toInt)
  } catch {
    case nfe: NumberFormatException => Left(nfe)
  }

  println(addInts2("1", "2"))

  println(addInts2("1", "x"))

  println(addInts2("x", "2"))
