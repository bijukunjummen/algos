package euler

import org.scalatest.FunSuite

class Problem017Test extends FunSuite {
	test("Number Letter Count") {
	  assert(verbalize(10)==="Ten")
	}
	
	def verbalize(n: Int): String = {
	  ""
	} 
	
	def basicVerbalizeMap(n: Int) = 
	  n match {
	    case 1 => "One"
	    case 2 => "Two"
	    case 3 => "Three"
	    case 4 => "Four"
	    case 5 => "Five"
	    case 6 => "Six"
	    case 7 => "Seven"
	    case 8 => "Eight"
	    case 9 => "Nine"
	    case 10 => "Ten"
	    case 11 => "Eleven"
	    case 12 => "Twelve"
	    case 13 => "Thirteen"
	    case 14 => "Fourteen"
	    case 15 => "Fifteen"
	    case 16 => "Sixteen"
	    case 17 => "Seventeen"
	    case 18 => "Eighteen"
	    case 19 => "Nineteen"
	    case 20 => "Twenty"
	    case 30 => "Thirty"
	    case 40 => "Fourty"
	    case 50 => "Fifty"
	    case 60 => "Sixty"
	    case 70 => "Seventy"
	    case 80 => "Eighty"
	    case 90 => "Ninety"
	    case 1000 => "One Thousand"
	  }
}