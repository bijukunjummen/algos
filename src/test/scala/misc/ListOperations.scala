package misc

import org.scalatest.FunSuite

class ListOperations extends FunSuite {

  test("sum of elements of List(4, 8, 9) is 21") {
    assert(sumOf(List(4,8,9)) === 21)
  }

  test("Appending an element to a list with :+ ") {
    val l = List("a", "b", "c")
    assert(l :+ "d" === List("a", "b", "c", "d"))
  }

  test("Pre-pending an element to a list with :+ ") {
    val l = List("a", "b", "c")
    assert("d" +: l === List("d", "a", "b", "c"))
  }

  test("Pre-pending an element to a list with :: ") {
    val l = "a" :: "b" :: "c" :: Nil
    assert("d" :: l === List("d", "a", "b", "c"))
  }

  test("Append two lists together") {
    val a = List("a1", "a2", "a3")
    val b = List("b1", "b2", "b3")
    assert(a ++ b === List("a1", "a2", "a3", "b1", "b2", "b3") )
    assert(b ++ a === List("b1", "b2", "b3", "a1", "a2", "a3") )
  }

  test("Mapping to upper case") {
    val l = List("a", "b", "c")
    val u = l.map(_.toUpperCase)

    assert(u === List("A", "B", "C"))
  }

  def sumOf(l: List[Int]): Int = {
    l match {
      case h :: t => h + sumOf(t)
      case Nil => 0
    }
  }
}
