// src/main/scala/modulework/curried-addition.scala
package modulework

object curryAdd {
  def addition(a: Int, b: Int): Int = {
    return a + b
  }

  val curriedAddition = (addition _).curried

  val increment = curriedAddition(1)

  val decrement = curriedAddition(-1)

  def mapOverList(ints: List[Int], f: Int => Int): List[Int] = {
    @scala.annotation.tailrec
    def applyChange(ints: List[Int], accum: List[Int]): List[Int] = ints match {
      case Nil => accum
      case head :: tail => applyChange(tail, accum :+ f(head))
    }
    applyChange(ints, Nil)
  }

  def main(args: Array[String]) {
    addition(3,4)
    curriedAddition(3)(4)
    increment(2)
    decrement(2)

    val nums = List(1,2,3,4,5)

    val incNums = mapOverList(nums, increment)
    val decNums = mapOverList(nums, decrement)

    println(incNums)
    println(decNums)
  }
}
