// src/main/scala/bookwork/ch7-forcomprehensions/for-tries-good.sc

def positive(i: Int): Try[Int] = Try{
  assert(i > 0, s"nonpositibe number $i")
  i
}

for {
  i1 <- positive(5).right
  i2 <- positive(10 * i1).right
  i3 <- positive(25 * i2).right
  i4 <- positive(2 * i3).right
} yield (i1 + i2 + i3 + i4)
// Returns: scala.util.Try[Int] = Success(3805)

for {
  i1 <- positive(5).right
  i2 <- positive(-1 * i1).right
  i3 <- positive(25 * i2).right
  i4 <- positive(-2 * i3).right
} yield (i1 + i2 + i3 + i4)
// Returns: scala.util.Try[Int] = Failure(
//  scala.util.AssertionError: assertion failed: nonpositive number -5)
