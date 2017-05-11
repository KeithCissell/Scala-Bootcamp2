// src/main/scala/bookwork/ch6-functionalprogramming/package.scala
package bookwork.fp
package object datastructs {
  type Seq[+A] = scala.collection.immutable.Seq[A]
  val Seq = scala.collection.immutable.Seq
}
