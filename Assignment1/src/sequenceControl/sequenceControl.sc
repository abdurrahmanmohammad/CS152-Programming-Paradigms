package sequenceControl

object sequenceControl {
  /** Problem 1 */
  // Kingdom 1: n % 2 == 0, n > 10, n % 100 == 0
  // Kingdom 2: n % 2 == 0, n > 10, n % 100 != 0
  // Kingdom 3: n <= 10
  // Kingdom 4: everything else
  def kingdom(n: Int): Int =
    if (n > 10)
      if (n % 2 == 0)
        if (n % 100 == 0) 1
        else 2
      else 4
    else 3                                        //> kingdom: (n: Int)Int
  // Test: Problem 1
  // Kingdom 1
  kingdom(200)                                    //> res0: Int = 1
  kingdom(500)                                    //> res1: Int = 1
  // Kingdom 2
  kingdom(14)                                     //> res2: Int = 2
  kingdom(222)                                    //> res3: Int = 2
  // Kingdom 3
  kingdom(0)                                      //> res4: Int = 3
  kingdom(1)                                      //> res5: Int = 3
  kingdom(2)                                      //> res6: Int = 3
  kingdom(10)                                     //> res7: Int = 3
  // Kingdom 4
  kingdom(11)                                     //> res8: Int = 4
  kingdom(37)                                     //> res9: Int = 4
  kingdom(99)                                     //> res10: Int = 4
  kingdom(333)                                    //> res11: Int = 4

  /** Problem 2 */
  // if (n <= 0) order(n) = 0 else order(n) = family(n) * class(n) + genus(n)
  // if (n == 50) class(n) = 3 else class(n) = 4
  // if (n % 3 == 0) family(n) = 1 else family(n) = 2
  // if (n % 7 == 0) genus(n) = 5 else genus(n) = 6
  def order(n: Int): Int =
    if (n >= 0)
      if (n == 50) 2 * 3 * 6
      else if (n % 3 == 0)
        if (n % 7 == 0) 1 * 4 * 5
        else 1 * 4 * 6
      else if (n % 7 == 0) 2 * 4 * 6
      else 2 * 4 * 5
    else 0                                        //> order: (n: Int)Int

  order(-5)                                       //> res12: Int = 0
  order(0)                                        //> res13: Int = 20
  order(1)                                        //> res14: Int = 40
  order(2)                                        //> res15: Int = 40
  order(3)                                        //> res16: Int = 24
  order(4)                                        //> res17: Int = 40
  order(5)                                        //> res18: Int = 40
  order(6)                                        //> res19: Int = 24
  order(7)                                        //> res20: Int = 48

  /** Problem 3 */
  // The line has 2 if statements and only 1 else statement.
  // It should hve 2 else statements.
  // By adding the second else statement, we define the function for all integers.
  def species(n: Int) =
    if (0 < n)
      if (n % 2 == 0) 1
      else 2
    else 2                                        //> species: (n: Int)Int

  /** Problem 4 */
  def tax(income: Double) = income match {
    case income if income < 0 => throw new Exception("Negative income")
    case income if income < 20000 => income * 0.00
    case income if income < 30000 => income * 0.05
    case income if income < 40000 => income * 0.11
    case income if income < 60000 => income * 0.23
    case income if income < 100000 => income * 0.32
    case income if income >= 100000 => income * 0.50
  }                                               //> tax: (income: Double)Double

  // --- Sample Session ---
  tax(12300)                                      //> res21: Double = 0.0
  tax(29000)                                      //> res22: Double = 1450.0
  tax(125000)                                     //> res23: Double = 62500.0
  tax(1000000)                                    //> res24: Double = 500000.0
  try {
    tax(-1000000)
  } catch {
    case e: Exception => println(e)
  }                                               //> java.lang.Exception: Negative income
                                                  //| res25: AnyVal = ()
  /** Problem 5 */
  def drawRectangle(l: Int, w: Int) {
    if (l < 0) throw new Exception("Invalid length")
    else if (w < 0) throw new Exception("Invalid width")
    else {
      for (i <- 1 to l) {
        for (j <- 1 to w) {
          print("*")
        }
        println()
      }
    }
  }                                               //> drawRectangle: (l: Int, w: Int)Unit
  // --- Sample Session ---
  drawRectangle(3, 4)                             //> ****
                                                  //| ****
                                                  //| ****
  drawRectangle(2, 7)                             //> *******
                                                  //| *******
  /** Problem 6 */
  // Write a procedure that prints the sums of all integers i and j for 0 <= i < n and 0 <= j < m.
  // Notes: Use a for loop with multiple generators.
  def printSums(n: Int, m: Int) {
    for (i <- 0 until n; j <- 0 until m) {
      println(i + " + " + j + " = " + (i + j))
    }
  }                                               //> printSums: (n: Int, m: Int)Unit
  printSums(3, 4)                                 //> 0 + 0 = 0
                                                  //| 0 + 1 = 1
                                                  //| 0 + 2 = 2
                                                  //| 0 + 3 = 3
                                                  //| 1 + 0 = 1
                                                  //| 1 + 1 = 2
                                                  //| 1 + 2 = 3
                                                  //| 1 + 3 = 4
                                                  //| 2 + 0 = 2
                                                  //| 2 + 1 = 3
                                                  //| 2 + 2 = 4
                                                  //| 2 + 3 = 5
  /** Problem 7 */
  // Located in BlackJack1, BlackJack2, BlackJack3 files
  /** Problem 8 */
  // In numerology a positive integer belongs to one of 6 realms.
  // All odd numbers belong to realm 1.
  // Even integers not divisible by 3 belong to realm 2.
  // Multiples of 6 and 7 belong to realm 3.
  // All other numbers belong to realm 0.
  def realm1(n: Int): Int = if (n % 2 == 1) 1 else throw new Exception("Invalid realm 1")
                                                  //> realm1: (n: Int)Int
  def realm2(n: Int): Int = if (n % 2 == 0 && n % 3 != 0) 2 else throw new Exception("invalid realm 2")
                                                  //> realm2: (n: Int)Int
  def realm3(n: Int): Int = if (n % 6 == 0 || n % 7 != 0) 3 else throw new Exception("invalid realm 3")
                                                  //> realm3: (n: Int)Int
  def realm(n: Int): Int =
    try {
      realm1(n) // Check if n belongs to realm 1
    } catch {
      case e: Exception => { // If an exception is thrown, check next realm
        try {
          realm2(n) // Check if n belongs to realm 2
        } catch {
          case e: Exception => { // If an exception is thrown, check next realm
            try {
              realm3(n) // Check if n belongs to realm 2
            } catch { // If all realms are checked
              case e: Exception => 0 // All other numbers belong to realm 0
            }
          }
        }
      }
    }                                             //> realm: (n: Int)Int
  /** Problem 9 */

  def sqrtLog(x: Double) = x match {
    case x if (x <= 0) => None
    case _ => Some(math.sqrt(math.log(x)))
  }                                               //> sqrtLog: (x: Double)Option[Double]

  def sqrtLog1(x: Double) = math.sqrt(math.log(x))//> sqrtLog1: (x: Double)Double
  sqrtLog1(64)                                    //> res26: Double = 2.039333980337618
}