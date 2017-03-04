package euler

import org.scalatest.FunSuite

import scala.math.BigInt

class Problem015Test extends FunSuite {

  test("Lattice paths") {
    assert(choose(40, 20) === BigInt("137846528820"))
  }

  def choose(n: Int, m: Int): BigInt = {
    fact(n, m) / fact(m, 1)
  }


  def fact(n1: Int, n2: Int): BigInt = {
    def fact(res: BigInt, m1: Int, m2: Int): BigInt = {
      if (m1 <= m2) res
      else fact(res * m1, m1 - 1, m2)
    }

    fact(1, n1, n2)
  }

}