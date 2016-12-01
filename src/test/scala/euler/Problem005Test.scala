package euler

import org.scalatest.FunSuite

class Problem005Test extends FunSuite{
	test("Smallest multiple") {
	  val o = from(21).iterator.find(isDivisibleByRange(_, Range(2, 21)))
	  o match {
	    case Some(i) => assert(i===232792560)
	    case None => println("Nothing found!")
	  }
	}
	
	def from(n: Int): Stream[Int] = n #:: from(n + 1)
	
	def isDivisibleByRange(n: Int, r: Range) = {
	  r.forall(n % _ == 0)
	}
}