import java.lang.Long
import scala.math.BigInt
import scala.annotation.tailrec

object euler {

  def nextPrime(n: Int) = {
    Stream.from(n).filter(isPrime)
  }                                               //> nextPrime: (n: Int)scala.collection.immutable.Stream[Int]
  
  def isPrime(n: Int) = {
    val r = 2 to math.sqrt(n).intValue
    r.forall(n % _ > 0)
  }                                               //> isPrime: (n: Int)Boolean
  
  nextPrime(2).iterator.takeWhile(_ <= 2000000).foldLeft(0l)(_ + _)
                                                  //> res0: Long = 142913828922
	                                              
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}