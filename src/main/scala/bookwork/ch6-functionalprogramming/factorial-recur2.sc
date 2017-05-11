// src/main/scala/bookwork/ch6-functionalprogramming/factorial-recur2.sc
import scala.annotation.tailrec

def factorial(i: BigInt): BigInt = {
  @tailrec
  def fact(i:BigInt, accumulator: BigInt): BigInt =
    if (i == 0) accumulator
    else fact(i - 1, i * accumulator)

    fact(i, 1)
}

for (i <- 1 to 10)
  println(s"$i:\t${factorial(i)}")
