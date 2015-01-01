package bucket

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PouringTest extends FunSuite {
  test("Initial set-up of the Pouring problem") {
    val p = Pouring(Vector(12, 8, 5), Vector(12, 0, 0))
    
    println(p.solution(Vector(6, 6, 0)))
  }
}