object newton {
  def abs(x: Double) = if (x < 0) -x else x       //> abs: (x: Double)Double

  def isGoodEnough(guess: Double, x: Double) = {
  	println(abs(guess * guess - x))
    abs(guess * guess - x) < 0.001
  }                                               //> isGoodEnough: (guess: Double, x: Double)Boolean

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2                       //> improve: (guess: Double, x: Double)Double

  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)           //> sqrtIter: (guess: Double, x: Double)Double

  def sqrt(x: Double) = sqrtIter(1, x)            //> sqrt: (x: Double)Double
  sqrt(10)                                        //> 9.0
                                                  //| 20.25
                                                  //| 3.3889462809917354
                                                  //| 0.21444848336856914
                                                  //| 0.001125566203938888
                                                  //| 3.1668918154537096E-8
                                                  //| res0: Double = 3.162277665175675
  sqrt(2)                                         //> 1.0
                                                  //| 0.25
                                                  //| 0.006944444444444198
                                                  //| 6.007304882427178E-6
                                                  //| res1: Double = 1.4142156862745097
}