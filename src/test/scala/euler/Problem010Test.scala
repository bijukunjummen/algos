package euler

import org.scalatest.FunSuite

class Problem010Test extends FunSuite {
  test("Summation of primes") {
    val p = nextPrime(2).iterator.takeWhile(_ < 2000000).foldLeft(0l)(_ + _)

    println(p)
  }

  def nextPrime(n: Int) = {
    Stream.from(n).filter(isPrime)
  }

  def isPrime(n: Int) = {
    val r = 2 to math.sqrt(n).intValue
    r.forall(n % _ > 0)
  }
}