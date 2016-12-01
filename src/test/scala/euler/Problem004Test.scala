package euler

import org.scalatest.FunSuite

class Problem004Test extends FunSuite{
	test("Palindrome with 3 digit") {
	  val ps = for {
	    i <- 100 to 999
	    j <- 100 to i
	    if (isPalindrome(i * j))
	  } yield (i * j)
	  assert(ps.max === 906609)
	}


	
	def isPalindrome(i: Long) =  {
	  i.toString == i.toString.reverse
	}
}