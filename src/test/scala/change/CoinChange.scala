package change

import org.scalatest.FunSuite

class CoinChange extends FunSuite {

  test("countChange: example given in instructions") {
    assert(countChange(4, List(1, 2)) === 3)
    println(countChangeWithPath(4, List(1, 2), Nil))
  }

  test("countChange: sorted CHF") {
    assert(countChange(300, List(5, 10, 20, 50, 100, 200, 500)) === 1022)
  }

  test("countChange: no pennies") {
    assert(countChange(301, List(5, 10, 20, 50, 100, 200, 500)) === 0)
    //    println(countChangeWithPath(300, List(5,10,20,50,100,200,500), Nil))
  }

  test("countChange: unsorted CHF") {
    assert(countChange(300, List(500, 5, 50, 100, 20, 200, 10)) === 1022)
  }


  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0) 0
    else if (money == 0) 1
    else {
      coins match {
        case Nil => 0
        case h :: t => countChange(money - h, coins) + countChange(money, t)
      }
    }
  }

  type CoinPath = List[Int]

  def countChangeWithPath(money: Int, coins: List[Int], history: CoinPath): List[CoinPath] = {
    if (money < 0) List[CoinPath]()
    else if (money == 0) {
      List(history)
    } else {
      coins match {
        case Nil => List[CoinPath]()
        case h :: t => countChangeWithPath(money - h, coins, h :: history) ++ countChangeWithPath(money, t, history)
      }
    }
  }

}
