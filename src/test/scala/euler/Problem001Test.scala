package euler

import org.scalatest.FunSuite

class Problem001Test extends FunSuite {
  test("Multiples of 3 or 5") {
    val m3or5 = for {
      i <- 1 until 1000
      if (i % 3 == 0 || i % 5 == 0)
    } yield i

    assert(m3or5.sum === 233168)
  }
}