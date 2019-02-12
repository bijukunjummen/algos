package bucket

import org.scalatest.FunSpec

class PouringTest extends FunSpec {
  describe("Initial set-up of the Pouring problem") {
    it("should work for 3 glasses") {
      val p = Pouring(Vector(12, 8, 5), Vector(12, 0, 0))

      p.solution(Vector(6, 6, 0)).take(1).foreach(println)
    }

    it("should work for 2 glasses") {
      val p = Pouring(Vector(4, 9), Vector(0, 0))

      p.solution(Vector(0, 6)).take(3).foreach(println)
    }

  }
}