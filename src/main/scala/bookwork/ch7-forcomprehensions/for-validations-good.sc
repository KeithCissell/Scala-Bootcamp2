// src/main/scala/bookwork/ch7-forcomprehensions/for-validations-good.sc
import scalaz._, std.AllInstances._

def positive(i: Int): Validation[List[Int]] = {
  if (i > 0) Success(i)
  else Failure(List(s"Nonpositive integer $i"))
}

for {
  i1 <- positive(5).right
  i2 <- positive(10 * i1).right
  i3 <- positive(25 * i2).right
  i4 <- positive(2 * i3).right
} yield (i1 + i2 + i3 + i4)
// Returns: scalaz.Validation[List[String],Int] = Sucess(3805)

for {
  i1 <- positive(5).right
  i2 <- positive(-1 * i1).right
  i3 <- positive(25 * i2).right
  i4 <- positive(-2 * i3).right
} yield (i1 + i2 + i3 + i4)
// Returns: scalaz.Validation[List[String],Int] = Failure(
//  scala.util.AssertionError: assertion failed: nonpositive number -5)

positive(5) +++ positive(10) +++ positive(25)

positive(5) +++ positive(-10) +++ positive(25) +++ positive(-30)
