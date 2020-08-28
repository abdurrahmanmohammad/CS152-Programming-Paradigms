package mathematics

object Mathematics {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(179); 

  /** Problem 1 */
  // Test code from PolyTest
  // Code located in file poly.scala
  val p = (3.0, 9.0, -30.0);System.out.println("""p  : (Double, Double, Double) = """ + $show(p ));$skip(45);  // = (3x - 6) * (x + 5)
  println("eval(6, p) = " + poly.eval(6, p));$skip(45); 
  println("eval(2, p) = " + poly.eval(2, p));$skip(47); 
  println("eval(-5, p) = " + poly.eval(-5, p));$skip(41); 
  println("roots(p) = " + poly.roots(p));$skip(41); 
  println("deriv(p) = " + poly.deriv(p));$skip(54); 
  println("deriv2(p) = " + poly.deriv(poly.deriv(p)));$skip(117); 

  /** Problem 2 */
  // Test code from VectorTest
  // Code located in file vector.scala
  val v1 = (2.0, 2.0, 2.0);System.out.println("""v1  : (Double, Double, Double) = """ + $show(v1 ));$skip(27); 
  val v2 = (1.0, 0.0, 0.0);System.out.println("""v2  : (Double, Double, Double) = """ + $show(v2 ));$skip(27); 
  val v3 = (0.0, 1.0, 0.0);System.out.println("""v3  : (Double, Double, Double) = """ + $show(v3 ));$skip(49); 
  println("sum(v3, v2) = " + vector.sum(v3, v2));$skip(47); 
  println("mul(3, v1) = " + vector.mul(3, v1));$skip(49); 
  println("dot(v1, v2) = " + vector.dot(v1, v2));$skip(49); 
  println("dot(v2, v3) = " + vector.dot(v2, v3));$skip(49); 
  println("dot(v1, v1) = " + vector.dot(v1, v1));$skip(47); 
  println("length(v1) = " + vector.length(v1));$skip(47); 
  println("length(v2) = " + vector.length(v2));$skip(53); 
  println("theta(v1, v2) = " + vector.theta(v1, v2));$skip(53); 
  println("theta(v3, v2) = " + vector.theta(v3, v2));$skip(35); 
  println("pi/2 = " + Math.PI / 2);$skip(146); 

  /** Problem 3 */
  // Test code from testArith
  // Code located in file arithmetic.scala
  println("gcd(15, 12) = " + arithmetic.gcd(15, 12));$skip(53); 
  println("lcm(15, 12) = " + arithmetic.lcm(15, 12));$skip(53); 
  println("gcd(13, 12) = " + arithmetic.gcd(13, 12));$skip(55); 
  println("gcd(-13, 12) = " + arithmetic.gcd(-13, 12));$skip(42); 
  println("phi(9)= " + arithmetic.phi(9));$skip(47); 
  println("sqrt(49) = " + arithmetic.sqrt(49));$skip(47); 
  println("sqrt(37) = " + arithmetic.sqrt(37));$skip(47); 
  println("sqrt(35) = " + arithmetic.sqrt(35));$skip(45); 
  println("log(64) = " + arithmetic.log(64));$skip(47); 
  println("log(130) = " + arithmetic.log(130));$skip(43); 
  println("log(9) = " + arithmetic.log(9));$skip(43); 
  println("log(0) = " + arithmetic.log(0));$skip(53); 
  println("isPrime(23) = " + arithmetic.isPrime(23));$skip(53); 
  println("isPrime(59) = " + arithmetic.isPrime(59));$skip(53); 
  println("isPrime(75) = " + arithmetic.isPrime(75));$skip(389); 

  /** Problem 4 */

  def rollDice(): (Int, Int) = {
    // Implemented using the function math.random
    // Numbers generated from 1 to 6 inclusive.
    // With this method, a differenet sequence is produced after every restart.
    // If a numbers are not generated randomly, you input time into the random generator.
    ((math.random * 6 + 1).toInt, (math.random * 6 + 1).toInt)
  };System.out.println("""rollDice: ()(Int, Int)""");$skip(56); val res$0 = 
  // ---------- Test rollDice() ----------
  rollDice();System.out.println("""res0: (Int, Int) = """ + $show(res$0));$skip(13); val res$1 = 
  rollDice();System.out.println("""res1: (Int, Int) = """ + $show(res$1));$skip(13); val res$2 = 
  rollDice();System.out.println("""res2: (Int, Int) = """ + $show(res$2));$skip(448); 

  def rollDice1(): (Int, Int) = {
    // Implemented using Scala's random number generator scala.util.Random
    val rand = scala.util.Random // Create a random number generator
    // Numbers generated from 1 to 6 inclusive.
    // With this method, a differenet sequence is produced after every restart.
    // If a numbers are not generated randomly, you input time into the random generator.
    (rand.nextInt(6) + 1, rand.nextInt(6) + 1)
  };System.out.println("""rollDice1: ()(Int, Int)""");$skip(58); val res$3 = 
  // ---------- Test rollDice1() ----------
  rollDice1();System.out.println("""res3: (Int, Int) = """ + $show(res$3));$skip(14); val res$4 = 
  rollDice1();System.out.println("""res4: (Int, Int) = """ + $show(res$4));$skip(14); val res$5 = 
  rollDice1();System.out.println("""res5: (Int, Int) = """ + $show(res$5))}

}
