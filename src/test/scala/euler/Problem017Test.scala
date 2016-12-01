package euler

import org.scalatest.FunSuite

class Problem017Test extends FunSuite {
	test("Number Letter Count In Thousands") {
	  println(verbalize(2311))
	  assert(verbalize(2311) === "Two Thousand Three Hundred and Eleven")
	  assert(verbalize(5231) === "Five Thousand Two Hundred and Thirty One")
	  assert(verbalize(231) === "Two Hundred and Thirty One")
	  assert(verbalize(201) === "Two Hundred and One")
	  assert((1 to 5).map(verbalize).map(len).sum === 19)
	  
	 
	  assert(len(verbalize(342)) == 23)
	  assert(len(verbalize(115)) == 20)
	  assert( (1 to 1000).map(verbalize).map(len).sum === 21124 )
	}
	
	def len(verbalized: String) = {
	  verbalized.replaceAll("\\s+", "").length()
	}
	
	def verbalize(n: Int): String = {
	  require( n <= 10000)
	  val thousplace = n / 1000
	  val rem1 = n % 1000
	  val hundplace = (rem1) / 100
	  val rem2 = rem1 % 100
	  val tenplace = rem2 / 10
	  val rem3 = rem2 % 10
	  val onesplace = rem3
	  
	  val thous = if (thousplace != 0) basicUnitsVerbalizeMap(thousplace) + " Thousand" else "" 
	  val hund = if  (hundplace != 0) {
		val thouspre = if (thous!="") " " else ""
		thouspre + basicUnitsVerbalizeMap(hundplace) + " Hundred" 
	  }else ""
	    
	  val thouswithhund = thous + hund
	    
	  val tens2Dig = if (rem2 != 0) {
	    val tens2DigVerbalized = basicTens2DigVerbalizeMap(rem2)
	    val hundpre = if (thouswithhund!="" && tens2DigVerbalized != "") " and " else ""
	    hundpre + tens2DigVerbalized
	  }else ""
	  
	  val tens = if (tens2Dig == "") {
	    val tenplaceVerbalized = basicTens1DigVerbalizeMap(tenplace)
	    val hundpre = if (thouswithhund != "" && tenplaceVerbalized != "") " and " else ""
	    hundpre + tenplaceVerbalized
	  }else ""
	  
	  val ones = if (tens2Dig == "") {
	    val onesVerbalized = basicUnitsVerbalizeMap(onesplace)
	    val hundpre = if ((thouswithhund != "" && onesVerbalized != "") && (tens == "" && tens2Dig == "")) " and " else ""
	    val tenspre = if (tens != "" || tens2Dig != "") " " else ""
	    hundpre + tenspre + onesVerbalized
	  }else ""
	    
	  thous + hund + tens2Dig + tens + ones
	  
	} 
	
	def basicUnitsVerbalizeMap(n: Int) = 
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
	    case _ => ""
	  }
	def basicTens2DigVerbalizeMap(n: Int) = 
	  n match {
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
	    case 40 => "Forty"
	    case 50 => "Fifty"
	    case 60 => "Sixty"
	    case 70 => "Seventy"
	    case 80 => "Eighty"
	    case 90 => "Ninety"
	    case _ => ""
	  }	

	def basicTens1DigVerbalizeMap(n: Int) = 
	  n match {
	    case 1 => "Ten"
	    case 2 => "Twenty"
	    case 3 => "Thirty"
	    case 4 => "Forty"
	    case 5 => "Fifty"
	    case 6 => "Sixty"
	    case 7 => "Seventy"
	    case 8 => "Eighty"
	    case 9 => "Ninety"
	    case _ => ""
	  }	
	
}