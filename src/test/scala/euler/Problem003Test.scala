package euler

import org.scalatest.FunSuite

class Problem003Test extends FunSuite{
	test("Largest prime factor") {
	  val l = 600851475143l
	  val primeFactors = for {
	    i <- 1l until math.sqrt(l * 1.0d).toLong
	    if (isDivisible(l, i) && isPrime(i))
	  } yield i
	  assert(primeFactors.isEmpty === false)
	  assert(primeFactors.last === 6857)
	}
	
	def isPrime(n: Long) = {
	  def loopAndCheck(from: Long, to: Long): Boolean = {
	    val d = isDivisible(n, from)
	    if (d) false
	    else if (from >= to) {
	      !d
	    }else { 
	      loopAndCheck(from + 1, to)
	    }
	  }
	  loopAndCheck(2, math.sqrt(n * 1.0d).toLong)
	}
	
	def isDivisible(n: Long, f: Long) = n % f == 0
}