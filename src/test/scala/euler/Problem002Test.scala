package euler

import org.scalatest.FunSuite

class Problem002Test extends FunSuite {
  test("Sum of Fib upto 4 million") {
    val fibs = fibsFrom(1, 2)
    val sum = fibs.takeWhile(f => f <= 4000000l).filter(_ % 2 == 0).sum
    assert(sum === 4613732)
  }

  def fibsFrom(a: Long, b: Long): Stream[Long] = {
    a #:: fibsFrom(b, a + b)
  }
}