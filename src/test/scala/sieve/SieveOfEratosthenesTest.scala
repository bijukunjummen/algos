package sieve

import org.scalatest.FunSpec

class SieveOfEratosthenesTest extends FunSpec {

  describe("Sieve of Eratosthenes") {
    it("should contain 4 primes under 10") {
      assert(sieve(from(2)).take(20).toList.filter( _ <= 10).size === 4)
    }
  }

  /**
    * Generate a stream of natural numbers starting from n
    * @param n to start from
    * @return Stream of natural numbers
    */
  def from(n: Int): Stream[Int] = n #:: from(n + 1)

  /**
    * Applying the sieve, return head of whatever remains and remove all multiples of current head
    *
    * @param s
    * @return
    */
  def sieve(s: Stream[Int]): Stream[Int] = {
    s.head #:: sieve(s.tail.filter(_ % s.head != 0))
  }

}
