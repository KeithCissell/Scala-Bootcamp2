// src/main/scala/bookwork/ch4-patternmatching/match-seq-reverse.sc

val nonEmptySeq     = Seq(1, 2, 3, 4, 5)
val emptySeq        = Seq.empty[Int]
val nonEmptyList    = List(1, 2, 3, 4, 5)
val emptyList       = Nil
val nonEmptyVector  = Vector(1, 2, 3, 4, 5)
val emptyVector     = Vector.empty[Int]
val nonEmptyMap     = Map("one" -> 1, "two" -> 2, "three" -> 3)
val emptyMap        = Map.empty[String, Int]

def reverseSeqToString[T](l: Seq[T]): String = l match {
  case prefix :+ end => reverseSeqToString(prefix) + s" :+ $end"
  case Nil => "Nil"
}

for (seq <- Seq(
    nonEmptySeq, emptySeq, nonEmptyList, emptyList,
    nonEmptyVector, emptyVector, nonEmptyMap.toSeq, emptyMap.toSeq)) {
  println(reverseSeqToString(seq))
}
