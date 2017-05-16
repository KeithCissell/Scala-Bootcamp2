// src/main/scala/bookwork/ch7-forcomprehensions/for-option-seq.sc

val results: Seq[Option[Int]] = Vector(Some(10), None, Some(20))

val results2 = for {
  Some(i) <- results
} yield (2 * i)
// Returns: Seq[Int] = Vector(20, 40)

// Translation step 1
val results2b = for {
  Some(i) <- results withFilter {
    case Some(i) => true
    case None => false
  }
} yield (2 * i)

// Translation step 2
val result2c = results withFilter {
  case Some(i) => true
  case None => false
} map {
  case Some(i) => (2 * i)
}
