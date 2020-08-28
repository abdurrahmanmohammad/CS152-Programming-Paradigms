package sequenceControl

object sequenceControl {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(356); 
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
    else 3;System.out.println("""kingdom: (n: Int)Int""");$skip(51); val res$0 = 
  // Test: Problem 1
  // Kingdom 1
  kingdom(200);System.out.println("""res0: Int = """ + $show(res$0));$skip(15); val res$1 = 
  kingdom(500);System.out.println("""res1: Int = """ + $show(res$1));$skip(29); val res$2 = 
  // Kingdom 2
  kingdom(14);System.out.println("""res2: Int = """ + $show(res$2));$skip(15); val res$3 = 
  kingdom(222);System.out.println("""res3: Int = """ + $show(res$3));$skip(28); val res$4 = 
  // Kingdom 3
  kingdom(0);System.out.println("""res4: Int = """ + $show(res$4));$skip(13); val res$5 = 
  kingdom(1);System.out.println("""res5: Int = """ + $show(res$5));$skip(13); val res$6 = 
  kingdom(2);System.out.println("""res6: Int = """ + $show(res$6));$skip(14); val res$7 = 
  kingdom(10);System.out.println("""res7: Int = """ + $show(res$7));$skip(29); val res$8 = 
  // Kingdom 4
  kingdom(11);System.out.println("""res8: Int = """ + $show(res$8));$skip(14); val res$9 = 
  kingdom(37);System.out.println("""res9: Int = """ + $show(res$9));$skip(14); val res$10 = 
  kingdom(99);System.out.println("""res10: Int = """ + $show(res$10));$skip(15); val res$11 = 
  kingdom(333);System.out.println("""res11: Int = """ + $show(res$11));$skip(478); 

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
    else 0;System.out.println("""order: (n: Int)Int""");$skip(13); val res$12 = 

  order(-5);System.out.println("""res12: Int = """ + $show(res$12));$skip(11); val res$13 = 
  order(0);System.out.println("""res13: Int = """ + $show(res$13));$skip(11); val res$14 = 
  order(1);System.out.println("""res14: Int = """ + $show(res$14));$skip(11); val res$15 = 
  order(2);System.out.println("""res15: Int = """ + $show(res$15));$skip(11); val res$16 = 
  order(3);System.out.println("""res16: Int = """ + $show(res$16));$skip(11); val res$17 = 
  order(4);System.out.println("""res17: Int = """ + $show(res$17));$skip(11); val res$18 = 
  order(5);System.out.println("""res18: Int = """ + $show(res$18));$skip(11); val res$19 = 
  order(6);System.out.println("""res19: Int = """ + $show(res$19));$skip(11); val res$20 = 
  order(7);System.out.println("""res20: Int = """ + $show(res$20));$skip(289); 

  /** Problem 3 */
  // The line has 2 if statements and only 1 else statement.
  // It should hve 2 else statements.
  // By adding the second else statement, we define the function for all integers.
  def species(n: Int) =
    if (0 < n)
      if (n % 2 == 0) 1
      else 2
    else 2;System.out.println("""species: (n: Int)Int""");$skip(448); 

  /** Problem 4 */
  def tax(income: Double) = income match {
    case income if income < 0 => throw new Exception("Negative income")
    case income if income < 20000 => income * 0.00
    case income if income < 30000 => income * 0.05
    case income if income < 40000 => income * 0.11
    case income if income < 60000 => income * 0.23
    case income if income < 100000 => income * 0.32
    case income if income >= 100000 => income * 0.50
  };System.out.println("""tax: (income: Double)Double""");$skip(42); val res$21 = 

  // --- Sample Session ---
  tax(12300);System.out.println("""res21: Double = """ + $show(res$21));$skip(13); val res$22 = 
  tax(29000);System.out.println("""res22: Double = """ + $show(res$22));$skip(14); val res$23 = 
  tax(125000);System.out.println("""res23: Double = """ + $show(res$23));$skip(15); val res$24 = 
  tax(1000000);System.out.println("""res24: Double = """ + $show(res$24));$skip(78); val res$25 = 
  try {
    tax(-1000000)
  } catch {
    case e: Exception => println(e)
  };System.out.println("""res25: AnyVal = """ + $show(res$25));$skip(299); 
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
  };System.out.println("""drawRectangle: (l: Int, w: Int)Unit""");$skip(50); 
  // --- Sample Session ---
  drawRectangle(3, 4);$skip(22); 
  drawRectangle(2, 7);$skip(305); 
  /** Problem 6 */
  // Write a procedure that prints the sums of all integers i and j for 0 <= i < n and 0 <= j < m.
  // Notes: Use a for loop with multiple generators.
  def printSums(n: Int, m: Int) {
    for (i <- 0 until n; j <- 0 until m) {
      println(i + " + " + j + " = " + (i + j))
    }
  };System.out.println("""printSums: (n: Int, m: Int)Unit""");$skip(18); 
  printSums(3, 4);$skip(435); 
  /** Problem 7 */
  // Located in BlackJack1, BlackJack2, BlackJack3 files
  /** Problem 8 */
  // In numerology a positive integer belongs to one of 6 realms.
  // All odd numbers belong to realm 1.
  // Even integers not divisible by 3 belong to realm 2.
  // Multiples of 6 and 7 belong to realm 3.
  // All other numbers belong to realm 0.
  def realm1(n: Int): Int = if (n % 2 == 1) 1 else throw new Exception("Invalid realm 1");System.out.println("""realm1: (n: Int)Int""");$skip(104); 
  def realm2(n: Int): Int = if (n % 2 == 0 && n % 3 != 0) 2 else throw new Exception("invalid realm 2");System.out.println("""realm2: (n: Int)Int""");$skip(104); 
  def realm3(n: Int): Int = if (n % 6 == 0 || n % 7 != 0) 3 else throw new Exception("invalid realm 3");System.out.println("""realm3: (n: Int)Int""");$skip(593); 
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
    };System.out.println("""realm: (n: Int)Int""");$skip(135); 
  /** Problem 9 */

  def sqrtLog(x: Double) = x match {
    case x if (x <= 0) => None
    case _ => Some(math.sqrt(math.log(x)))
  };System.out.println("""sqrtLog: (x: Double)Option[Double]""");$skip(52); 

  def sqrtLog1(x: Double) = math.sqrt(math.log(x));System.out.println("""sqrtLog1: (x: Double)Double""");$skip(15); val res$26 = 
  sqrtLog1(64);System.out.println("""res26: Double = """ + $show(res$26))}
}
