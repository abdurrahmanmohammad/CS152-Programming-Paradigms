package mathematics
object arithmetic {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(487); 
  def sqrt(n: Int): Option[Int] = {
    // = None if n < 0
    if (n < 0) None
    else { // = largest int m such that m * m <= n
      // Base cases
      if (n == 0 || n == 1) Option(n)
      else { // Staring from 1, try all numbers until i * i is greater than or equal to n.
        var i = 1
        var result = 1
        while (result <= n) {
          i += 1 // i++
          result = i * i
        }
        Some(i - 1)
      }
    }

  };System.out.println("""sqrt: (n: Int)Option[Int]""");$skip(409); 

  def log(n: Int): Option[Int] = {
    // = None if N <= 0
    if (n <= 0) None
    else { // = largest m such that 2^m <= n
      // Base cases
      if (n == 1) Option(n)
      else {
        var result = 2 // 2^1 = 2
        var i = 1 // Records the exponent
        while (result <= n) {
          i += 1 // i++
          result *= 2 // result = resut * 2
        }
        Some(i - 1)
      }
    }
  };System.out.println("""log: (n: Int)Option[Int]""");$skip(255); 

  def isPrime(n: Int): Option[Boolean] = {
    // There are no negatice primes
    if (n <= 1) None
    else { // = true if n has no divisors > 1
      // Search [2, n/2]
      for (i <- 2 to n / 2 if (n % i == 0)) Some(false)
      Some(true)
    }
  };System.out.println("""isPrime: (n: Int)Option[Boolean]""");$skip(410); 

  def gcd(n: Int, m: Int): Option[Int] = {
    // = None if n or m < 0
    // = gcd(m, n) if n < m
    // = largest k dividing both n and m
    // base case
    // for (k <- 1 to n if (n % k == 0 && m % k == 0)) Some(k)

    if (n == m) Some(m)
    else if (n < m) gcd(m, n)
    else {
      for (k <- n to 1 if (n % k == 0 && m % k == 0)) Some(k)
      Some(1) // If there is no GCD aside form one
    }
  };System.out.println("""gcd: (n: Int, m: Int)Option[Int]""");$skip(254); 

  def lcm(n: Int, m: Int): Option[Int] = {
    // = None if n < 0 or m < 0
    // = smallest k such that n a,d m divide k
    if (n < 0 || m < 0) None
    else {
      for (k <- 1 to n if (k % n == 0 && k % m == 0)) Some(k)
      Some(n * m)
    }

  };System.out.println("""lcm: (n: Int, m: Int)Option[Int]""");$skip(226); 

  def phi(n: Int): Option[Int] = {
    // = None if n < 0
    // = # of k <= n such that gcd(k, n) = 1
    if (n < 0) None
    else {
      var k = 1
      for (i <- 2 to n if (gcd(i, n) == 1)) k += 1
      Some(k)
    }
  };System.out.println("""phi: (n: Int)Option[Int]""")}
}
object testArith extends App {
  println("gcd(15, 12) = " + arithmetic.gcd(15, 12))
  println("lcm(15, 12) = " + arithmetic.lcm(15, 12))
  println("gcd(13, 12) = " + arithmetic.gcd(13, 12))
  println("gcd(-13, 12) = " + arithmetic.gcd(-13, 12))
  println("phi(9)= " + arithmetic.phi(9))
  println("sqrt(49) = " + arithmetic.sqrt(49))
  println("sqrt(37) = " + arithmetic.sqrt(37))
  println("sqrt(35) = " + arithmetic.sqrt(35))
  println("log(64) = " + arithmetic.log(64))
  println("log(130) = " + arithmetic.log(130))
  println("log(9) = " + arithmetic.log(9))
  println("log(0) = " + arithmetic.log(0))
  println("isPrime(23) = " + arithmetic.isPrime(23))
  println("isPrime(59) = " + arithmetic.isPrime(59))
  println("isPrime(75) = " + arithmetic.isPrime(75))
}
