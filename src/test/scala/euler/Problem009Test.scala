package euler

import org.scalatest.FunSuite

class Problem009Test extends FunSuite {
  test("Special Pythagorean triplet") {
    val l = for {
      c <- 3 to 1000
      b <- 2 to c
      a <- 1 to b
      if (a * a + b * b == c * c)
      if (a + b + c == 1000)
    } yield (a, b, c)
    
    l match {
      case y +: ys => y match {
        case (a, b, c) => println(a * b * c)
      }
    }
  }
}