package v1

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

@RunWith(classOf[JUnitRunner])
class IntegerBSTTest extends FunSuite {
  test("Node Test") {
    val bst = new IntegerBST[String]()
    bst.put(10, "10")
    bst.put(1, "1")
    bst.put(100, "100")
    bst.put(5, "5")
    
    
    assert(bst.get(5) === "5")
    assert(bst.get(10) === "10")
    assert(bst.get(100) === "100")
    assert(bst.get(500) === null)
    
  }
}