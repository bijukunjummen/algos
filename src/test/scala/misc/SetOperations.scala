package misc

import org.scalatest.FlatSpec

class SetOperations extends FlatSpec {

  behavior of "an empty set"

  it should "have size 0" in {
    assert(Set.empty.size === 0)
  }

  "An empty set" should "have size 0" in {
    assert(Set.empty.size === 0)
  }

}
