package stringProcessing

object StringProcessing {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(595); 

  /** Problem 1 */
  def isPal(s: String) = {
    var trimmedString = s.trim() // Omit the leading and trailing spaces
    var isPalindrome = true
    var i = 0 // Points to beginning of string
    var j = trimmedString.length() - 1 // Points to end of string
    while (i < j) { // While there are characters to compare
      if (trimmedString(i) != trimmedString(j)) isPalindrome = false // If there is a mismatch
      i += 1 // Increment first pointer
      j -= 1 // Decrement second pointer
    }
    isPalindrome // Retun the value
  };System.out.println("""isPal: (s: String)Boolean""");$skip(19); val res$0 = 
  isPal("rotator");System.out.println("""res0: Boolean = """ + $show(res$0));$skip(15); val res$1 = 
  isPal("cat");System.out.println("""res1: Boolean = """ + $show(res$1));$skip(17); val res$2 = 
  isPal("Civic");System.out.println("""res2: Boolean = """ + $show(res$2));$skip(18); val res$3 = 
  isPal("Toyota");System.out.println("""res3: Boolean = """ + $show(res$3));$skip(16); val res$4 = 
  isPal("Anna");System.out.println("""res4: Boolean = """ + $show(res$4));$skip(16); val res$5 = 
  isPal("AnnA");System.out.println("""res5: Boolean = """ + $show(res$5));$skip(17); val res$6 = 
  isPal(" AnnA");System.out.println("""res6: Boolean = """ + $show(res$6));$skip(219); 

  /** Problem 2 */
  def isPal2(s: String) = {
    var str = s.replaceAll("[^A-Za-z]", "") // Remove punctuation
    str = str.toLowerCase() // Remove all cases
    isPal(str) // Whitespaces are removed in isPal()
  };System.out.println("""isPal2: (s: String)Boolean""");$skip(45); val res$7 = 

  isPal2("A man, a plan, a canal, Panama!");System.out.println("""res7: Boolean = """ + $show(res$7));$skip(34); val res$8 = 
  isPal2("Please, give me an A!")

  /** Problem 3 */
  import scala.util.Random;System.out.println("""res8: Boolean = """ + $show(res$8));$skip(332); 
  def mkWord(size: Int = 5) = { // Default length is 5
    val start = 97 // ASCII of 'a'
    val finish = 122 // ASCII of 'z'
    var word = "" // Create a var to store the word
    for (i <- 0 to size)
      word += (start + Random.nextInt((finish - start) + 1)).toChar
    word
  };System.out.println("""mkWord: (size: Int)String""");$skip(21); 

  val a1 = mkWord();System.out.println("""a1  : String = """ + $show(a1 ));$skip(20); 
  val a2 = mkWord();System.out.println("""a2  : String = """ + $show(a2 ));$skip(20); 
  val a3 = mkWord();System.out.println("""a3  : String = """ + $show(a3 ));$skip(22); 
  val a4 = mkWord(20);System.out.println("""a4  : String = """ + $show(a4 ));$skip(462); 

  /** Problem 4 */
  def mkSentence(size: Int = 10): String = {
    var sentence = "" // Create a var to store the sentence
    for (i <- 0 to size) {
      sentence += mkWord(Random.nextInt(9) + 1) // Make a random word
      sentence += " " // Store it with a space
    }
    sentence = sentence.trim // Remove the last space
    sentence += "." // Add a period to the end
    sentence.capitalize // Capitalize the first character and return the sentence
  };System.out.println("""mkSentence: (size: Int)String""");$skip(15); val res$9 = 
  mkSentence();System.out.println("""res9: String = """ + $show(res$9));$skip(15); val res$10 = 
  mkSentence();System.out.println("""res10: String = """ + $show(res$10));$skip(15); val res$11 = 
  mkSentence();System.out.println("""res11: String = """ + $show(res$11))}

  /** Problem 7 */
  // Check peano.scala
}
