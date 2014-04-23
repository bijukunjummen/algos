package euler

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Problem007Test extends FunSuite{
	test("10001st prime") {
	  val l = nextPrime(2).take(10001).takeRight(1).toList
	  assert(l(0) === 104743)
	}
	
	def nextPrime(n: Int) = {
	  Stream.from(n) filter(isPrime)
	}
	
	def isPrime(n: Int) = {
	  val r = (2 to math.sqrt(n * 1.0).intValue)
	  r.forall(n % _ > 0)
	}	
}