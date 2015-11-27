package misc

import org.scalatest.FunSuite

class SetOfDigitsTest extends FunSuite {

  test("digits of 10 is Set(1, 0)") {
    assert(digits(10) === Set(1, 0))
  }

  test("digits of 9999 is Set(9, 9, 9, 9)") {
    assert(digits(9999) === Set(9))
  }

  test("digits of 9876 is Set(9, 8, 7, 6)") {
    assert(digits(9876) === Set(6, 7, 8, 9))
  }

  def digits(n: Int): Set[Int] = {
    if (n < 0) digits(-n)
    else if (n < 10) Set(n)
    else digits(n / 10) + (n % 10)
  }
}
