package misc

import org.scalatest.FlatSpec

import scala.collection.mutable.ListBuffer

class ListBufferOperations extends FlatSpec {
  "Adding an element to a ListBuffer" should "modify the existing buffer" in {
    val l = ListBuffer(1, 2, 3)
    l += 4
    assert(l === ListBuffer(1,2,3,4))
  }

  "Adding a collection to a ListBuffer" should "modify the existing buffer" in {
    val l = ListBuffer(1,2)
    l += (3, 4)
    assert(l === ListBuffer(1,2,3,4))
  }
}
