// src/main/scala/modulework/forcomp-translation.scala
package modulework

object forComp {
  /*Translate:
  *
  * val nums = List(List(0, 10000, 22, 3093, 5), List (-1, -2, 400), List())
  * nums.flatMap(lst => lst.filter(num => num > 0).map(number => number.toString.length))
  *
  * into a for composition
  */
  def main(args: Array[String]) {
    val nums = List(List(0, 10000, 22, 3093, 5), List (-1, -2, 400), List())

    val numLengths = for {
      lst <- nums
      num <- lst
      if num > 0
    } yield {
      num -> num.toString.length
    }

    println(numLengths)
  }
}
