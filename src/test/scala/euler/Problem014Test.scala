package euler

import org.scalatest.FunSuite

class Problem014Test extends FunSuite {
  test("Longest Collatz sequence") {
    val r = (1 to 1000000)
    val (m, n) = r.foldLeft((0, 1))((m, n) => {
    	val l = countFor(n)
    	if (l > m._1) (l, n) else m
    })
    println(m + ":" + n)
  }

  test("seqLength of 13 should be 10") {
    assert(countFor(13) === 10)
  }
  
  
  def countFor(n: Int): Int = {
    def countFor(m: Long, c: Int): Int = {
      if (m == 1) c + 1
      else countFor(if (m % 2 == 0) m / 2 else 3 * m + 1, c + 1)
    }
    countFor(n, 0)
  }
}