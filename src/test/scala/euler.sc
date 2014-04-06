import java.lang.Long
import scala.math.BigInt

object euler {
	def fibFrom(a: Int, b: Int): Stream[Int] = {
	  a #:: fibFrom(b, a + b)
	}                                         //> fibFrom: (a: Int, b: Int)Stream[Int]
	
	
	fibFrom(1, 2).takeWhile(_ <= 4000000).filter(_ % 2 == 0).sum
                                                  //> res0: Int = 4613732
                                              
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}