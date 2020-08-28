package mathematics

object arithmetic extends App {

  def sqrt(n: Int): Option[Int] = {
    if (n < 0) None // = None if n < 0
    else if (n == 0 || n == 1) Option(n) // Base cases
    else { // = largest int m such that m * m <= n
      // Staring from 1, try all numbers until i * i is greater than or equal to n.
      var i = 1
      var result = 1
      while (result <= n) {
        i += 1 // i++
        result = i * i
      }
      Some(i - 1)
    }
  }

  def log(n: Int): Option[Int] = {
    if (n <= 0) None // = None if N <= 0
    else if (n == 1) Option(n) // Base cases
    else { // = largest m such that 2^m <= n
      var result = 2 // 2^1 = 2
      var i = 1 // Records the exponent
      while (result <= n) {
        i += 1 // i++
        result *= 2 // result = resut * 2
      }
      Some(i - 1)
    }
  }

  def isPrime(n: Int): Option[Boolean] = {
    if (n <= 1) None // There are no negative primes. 0 and 1 aren't prime.
    else { // = true if n has no divisors > 1
      var flag = true // Keeps track of n being prime or not
      for (i <- 2 until n if n % i == 0) flag = false // Check from 2 to n-1
      Some(flag)
    }
  }

  def gcd(n: Int, m: Int): Option[Int] = {
    if (n < 0 || m < 0) None // = None if n or m < 0
    else if (n < m) gcd(m, n) // = gcd(m, n) if n < m
    else if (n == m) Some(m)
    else { // = largest k dividing both n and m
      var gcd = 1
      for (k <- 1 to n if (n % k == 0 && m % k == 0)) gcd = k
      Some(gcd) // If there is no GCD aside form one
    }
  }

  def lcm(n: Int, m: Int): Option[Int] = {
    if (n < 0 || m < 0) None // = None if n < 0 or m < 0
    else if (n < m) lcm(m, n) // = lcm(m, n) if n < m
    else if (n == m) Some(m)
    else { // = smallest k such that n a,d m divide k
      var gcd = 1
      for (k <- 1 to n if (n % k == 0 && m % k == 0)) gcd = k // Find GCD
      Some((n * m) / gcd) // lcm(n, m) = (n * m) / gcd(n, m)
    }
  }

  def phi(n: Int): Option[Int] = {
    if (n < 0) None // = None if n < 0
    else { // = # of k <= n such that gcd(k, n) = 1
      var phi = 1
      for (i <- 2 to n if (gcd(i, n) == Some(1))) phi += 1
      Some(phi)
    }
  }
}
