// src/main/scala/bookwork/ch4-patternmatching/match-type.sc


// BAD CODE. Due to JVM type erasure, List type cannot be check at runntime
for {
  x <- Seq(List(5.5, 6.5, 7.5), List("a", "b"))
} yield (x match {
  case seqd: Seq[Double] => println("seq double", seqd)
  case seqs: Seq[String] => println("seq string", seqs)
  case _                 => println("unknown!", x)
})

// GOOD CODE. Matches Any on the collection and then matches with head to determine type
def doSeqMatch[T](seq: Seq[T]): String = seq match {
  case Nil => "Nothing"
  case head +: _ => head match {
    case _ : Double => "Double"
    case _ : String => "String"
    case _          => "Unmatched seq element"
  }
}

for {
  x <- Seq(List(5.5, 6.5, 7.5), List("a", "b"), Nil)
} yield {
  x match {
    case seq: Seq[_] => println(s"seq ${doSeqMatch(seq)}", seq)
    case _           => ("unknown!", x)
  }
}
