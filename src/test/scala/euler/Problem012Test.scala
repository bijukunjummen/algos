package euler

import org.scalatest.FunSuite

class Problem012Test extends FunSuite {
  test("Highly divisible triangular number") {
    val o = nextTriangularNumber(1).iterator.find(divisorsOf(_).size > 500)
    o match {
      case Some(n) => assert(n===76576500)
      case None => println("No such number found!")
    }
  }

  test("divisors of a number") {
    assert(divisorsOf(3) === List(1,3))
    assert(divisorsOf(28) === List(1,28, 2, 14, 4, 7))
  }
  
  def nextTriangularNumber(n: Int): Stream[Int] = {
    triangularNumberAt(n) #:: nextTriangularNumber(n + 1)
  }

  def triangularNumberAt(n: Int) = (n * (n + 1)) / 2;

  def divisorsOf(n: Int): List[Int] = {
    val l = (for {
      a <- (1 to math.sqrt(n).toInt)
      if (n % a == 0)
      b <- List(a, n / a).distinct
    } yield b)

    l.toList
  }
}