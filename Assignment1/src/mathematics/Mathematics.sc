package mathematics

object Mathematics {

  /** Problem 1 */
  // Test code from PolyTest
  // Code located in file poly.scala
  val p = (3.0, 9.0, -30.0) // = (3x - 6) * (x + 5)
                                                  //> p  : (Double, Double, Double) = (3.0,9.0,-30.0)
  println("eval(6, p) = " + poly.eval(6, p))      //> eval(6, p) = 132.0
  println("eval(2, p) = " + poly.eval(2, p))      //> eval(2, p) = 0.0
  println("eval(-5, p) = " + poly.eval(-5, p))    //> eval(-5, p) = 0.0
  println("roots(p) = " + poly.roots(p))          //> roots(p) = Some((2.0,-5.0))
  println("deriv(p) = " + poly.deriv(p))          //> deriv(p) = (0.0,6.0,9.0)
  println("deriv2(p) = " + poly.deriv(poly.deriv(p)))
                                                  //> deriv2(p) = (0.0,0.0,6.0)

  /** Problem 2 */
  // Test code from VectorTest
  // Code located in file vector.scala
  val v1 = (2.0, 2.0, 2.0)                        //> v1  : (Double, Double, Double) = (2.0,2.0,2.0)
  val v2 = (1.0, 0.0, 0.0)                        //> v2  : (Double, Double, Double) = (1.0,0.0,0.0)
  val v3 = (0.0, 1.0, 0.0)                        //> v3  : (Double, Double, Double) = (0.0,1.0,0.0)
  println("sum(v3, v2) = " + vector.sum(v3, v2))  //> sum(v3, v2) = (1.0,1.0,0.0)
  println("mul(3, v1) = " + vector.mul(3, v1))    //> mul(3, v1) = (6.0,6.0,6.0)
  println("dot(v1, v2) = " + vector.dot(v1, v2))  //> dot(v1, v2) = 2.0
  println("dot(v2, v3) = " + vector.dot(v2, v3))  //> dot(v2, v3) = 0.0
  println("dot(v1, v1) = " + vector.dot(v1, v1))  //> dot(v1, v1) = 12.0
  println("length(v1) = " + vector.length(v1))    //> length(v1) = 3.4641016151377544
  println("length(v2) = " + vector.length(v2))    //> length(v2) = 1.0
  println("theta(v1, v2) = " + vector.theta(v1, v2))
                                                  //> theta(v1, v2) = 0.9553166181245092
  println("theta(v3, v2) = " + vector.theta(v3, v2))
                                                  //> theta(v3, v2) = 1.5707963267948966
  println("pi/2 = " + Math.PI / 2)                //> pi/2 = 1.5707963267948966

  /** Problem 3 */
  // Test code from testArith
  // Code located in file arithmetic.scala
  println("gcd(15, 12) = " + arithmetic.gcd(15, 12))
                                                  //> gcd(15, 12) = Some(3)
  println("lcm(15, 12) = " + arithmetic.lcm(15, 12))
                                                  //> lcm(15, 12) = Some(60)
  println("gcd(13, 12) = " + arithmetic.gcd(13, 12))
                                                  //> gcd(13, 12) = Some(1)
  println("gcd(-13, 12) = " + arithmetic.gcd(-13, 12))
                                                  //> gcd(-13, 12) = None
  println("phi(9)= " + arithmetic.phi(9))         //> phi(9)= Some(6)
  println("sqrt(49) = " + arithmetic.sqrt(49))    //> sqrt(49) = Some(7)
  println("sqrt(37) = " + arithmetic.sqrt(37))    //> sqrt(37) = Some(6)
  println("sqrt(35) = " + arithmetic.sqrt(35))    //> sqrt(35) = Some(5)
  println("log(64) = " + arithmetic.log(64))      //> log(64) = Some(6)
  println("log(130) = " + arithmetic.log(130))    //> log(130) = Some(7)
  println("log(9) = " + arithmetic.log(9))        //> log(9) = Some(3)
  println("log(0) = " + arithmetic.log(0))        //> log(0) = None
  println("isPrime(23) = " + arithmetic.isPrime(23))
                                                  //> isPrime(23) = Some(true)
  println("isPrime(59) = " + arithmetic.isPrime(59))
                                                  //> isPrime(59) = Some(true)
  println("isPrime(75) = " + arithmetic.isPrime(75))
                                                  //> isPrime(75) = Some(false)

  /** Problem 4 */

  def rollDice(): (Int, Int) = {
    // Implemented using the function math.random
    // Numbers generated from 1 to 6 inclusive.
    // With this method, a differenet sequence is produced after every restart.
    // If a numbers are not generated randomly, you input time into the random generator.
    ((math.random * 6 + 1).toInt, (math.random * 6 + 1).toInt)
  }                                               //> rollDice: ()(Int, Int)
  // ---------- Test rollDice() ----------
  rollDice()                                      //> res0: (Int, Int) = (2,1)
  rollDice()                                      //> res1: (Int, Int) = (2,2)
  rollDice()                                      //> res2: (Int, Int) = (4,3)

  def rollDice1(): (Int, Int) = {
    // Implemented using Scala's random number generator scala.util.Random
    val rand = scala.util.Random // Create a random number generator
    // Numbers generated from 1 to 6 inclusive.
    // With this method, a differenet sequence is produced after every restart.
    // If a numbers are not generated randomly, you input time into the random generator.
    (rand.nextInt(6) + 1, rand.nextInt(6) + 1)
  }                                               //> rollDice1: ()(Int, Int)
  // ---------- Test rollDice1() ----------
  rollDice1()                                     //> res3: (Int, Int) = (4,2)
  rollDice1()                                     //> res4: (Int, Int) = (2,2)
  rollDice1()                                     //> res5: (Int, Int) = (1,5)

}