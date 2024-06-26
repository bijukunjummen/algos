package euler

import org.scalatest.FunSuite

class Problem006Test extends FunSuite {
  test("Sum Square Difference") {
    val sumOfSquares = Range(1, 101).map(i => i * i).sum
    val s = Range(1, 101).sum
    val squareOfSum = s * s

    println(squareOfSum - sumOfSquares)
  }
}