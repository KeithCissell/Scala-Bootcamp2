// src/main/scala/bookwork/ch5-implicits/implicit-erasure.sc

object M {
  implicit object IntMaker
  implicit object StringMaker

  def m(seq: Seq[Int])(implicit i: IntMaker.type): Unit =
    println(s"Seq[Int]: $seq")

  def m(seq: Seq[String])(implicit s: StringMaker.type): Unit =
    println(s"Seq[String]: $seq")
}

import M._
m(List(1,2,3))
m(List("one","two","three"))
