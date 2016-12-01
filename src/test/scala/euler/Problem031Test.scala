package euler

import org.scalatest.FunSuite

class Problem031Test extends FunSuite{
	test("UK Coins test") {
	  val cointypes = List(1, 2, 5, 10, 20, 50, 100, 200)
	  assert(countOfWays(200, cointypes).size === 73682)
	}
  
   	def countOfWays(total: Int, coindenom: List[Int]): List[List[Int]] = {
		def ways(a: Int, c: List[Int], hist: List[Int]): List[List[Int]] = {
			if (a == 0) {
				List(hist)
			}else if (a < 0){
				List()
			}else {
				c match {
					case Nil => Nil
					case _ => {
						val coin = c.head
						ways(a, c.tail, hist) ++ ways(a - coin, c, coin :: hist)
					}
				}
			}
		}
		
		ways(total, coindenom, List())
	}  
}