package euler

import org.scalatest.FunSuite

class Problem016Test extends FunSuite {
  test("Power Digit Sum") {
    val b = BigInt(1)
    println(sumOfDigits(b << 1000))
  }

  def sumOfDigits(b: BigInt) = {
    val cs = for {
      c <- b.toString
    } yield (c - '0')
    cs.sum
  }
}