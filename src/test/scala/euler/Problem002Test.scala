package euler

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Problem002Test extends FunSuite{
	test("Sum of even Fib upto 4 million") {
	  val fibs = fibFrom(1, 2)
	  
	  val sum = fibs.takeWhile(_ <= 4000000).filter(_ % 2 == 0).sum
	  
	  assert(sum === 4613732)
	  
	}
	
	def fibFrom(a: Int, b: Int): Stream[Int] = {
	  a #:: fibFrom(b, a + b)
	}
}