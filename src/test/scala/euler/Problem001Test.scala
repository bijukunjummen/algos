package euler

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Problem001Test extends FunSuite{
	test("Multiples of 3 and 5") {
	  val m = for {
	    i <- 1 until 1000
	    if (i %3 == 0 || i % 5 == 0)
	  } yield i
	  val s = m.reduceLeft(_ + _) // or m.sum
	  assert(s === 233168)
	}
  

}