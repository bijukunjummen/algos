package euler

import org.scalatest.FunSuite

import scala.collection.mutable.ListBuffer

class Problem018Test extends FunSuite {
  test("a basic directed graph - 1") {
    val d1 = new DGraph(2, 1)
    assert(d1.vertices === 2)
    assert(d1.edges === 1)
  }


}

class DGraph(val vertices: Int, val edges: Int) {
  val adj = new ListBuffer[ListBuffer[Int]]()
  (0 until vertices).foreach({ e =>
    adj += new ListBuffer[Int]();
  })

  def addEdge(from: Int, to: Int) = {
    adj(from)
  }
}