package bal

import org.scalatest.FunSuite

class BSTTest extends FunSuite {
  test("Basic Add to a BST") {
    val bst = new BST[Int, String]

    bst.put(1, "One")
    bst.put(2, "Two")
    bst.put(3, "Three")

    assert(bst.get(1) === Some("One"))
    assert(bst.get(2) === Some("Two"))
    assert(bst.get(3) === Some("Three"))
    assert(bst.get(10) === None)

    List(1,2,3).sum
  }
}
