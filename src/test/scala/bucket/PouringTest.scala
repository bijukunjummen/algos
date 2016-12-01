package bucket

import org.scalatest.FunSpec

class PouringTest extends FunSpec {
  describe("Initial set-up of the Pouring problem") {
    it("should work") {
      val p = Pouring(Vector(12, 8, 5), Vector(12, 0, 0))

      println(p.solution(Vector(6, 6, 0)))
    }
  }
}