package rbtree

import org.scalatest.FunSpec

class RedBlackBSTTest extends FunSpec {
  describe("A Redblack BST") {
    ignore("should be able to add and retrieve a few items") {
      val t = new RedBlackBST[String, String]
      t.put("1", "1")
      t.put("2", "2")
      t.put("3", "3")
      t.put("8", "8")
      t.put("5", "5")
      t.put("9", "9")

      assert(t.get("2") == Some("2"))
      assert(t.get("3") == Some("3"))
      assert(t.get("1") == Some("1"))
      assert(t.get("0") == None)
      assert(t.get("5") == Some("5"))
      assert(t.get("9") == Some("9"))
      assert(t.get("8") == Some("8"))

      assert(t.contains("2"))
    }
  }

}
