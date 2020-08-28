package stringProcessing

object StringProcessing {

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
  }                                               //> isPal: (s: String)Boolean
  isPal("rotator")                                //> res0: Boolean = true
  isPal("cat")                                    //> res1: Boolean = false
  isPal("Civic")                                  //> res2: Boolean = false
  isPal("Toyota")                                 //> res3: Boolean = false
  isPal("Anna")                                   //> res4: Boolean = false
  isPal("AnnA")                                   //> res5: Boolean = true
  isPal(" AnnA")                                  //> res6: Boolean = true

  /** Problem 2 */
  def isPal2(s: String) = {
    var str = s.replaceAll("[^A-Za-z]", "") // Remove punctuation
    str = str.toLowerCase() // Remove all cases
    isPal(str) // Whitespaces are removed in isPal()
  }                                               //> isPal2: (s: String)Boolean

  isPal2("A man, a plan, a canal, Panama!")       //> res7: Boolean = true
  isPal2("Please, give me an A!")                 //> res8: Boolean = false

  /** Problem 3 */
  import scala.util.Random
  def mkWord(size: Int = 5) = { // Default length is 5
    val start = 97 // ASCII of 'a'
    val finish = 122 // ASCII of 'z'
    var word = "" // Create a var to store the word
    for (i <- 0 to size)
      word += (start + Random.nextInt((finish - start) + 1)).toChar
    word
  }                                               //> mkWord: (size: Int)String

  val a1 = mkWord()                               //> a1  : String = lloykv
  val a2 = mkWord()                               //> a2  : String = hfggia
  val a3 = mkWord()                               //> a3  : String = aayqci
  val a4 = mkWord(20)                             //> a4  : String = kpennehcqmbnzjfwmdtmr

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
  }                                               //> mkSentence: (size: Int)String
  mkSentence()                                    //> res9: String = Irswmbcqyi kb ydqnbidrrq afdww xmh misp dognueutci ymmwgjnor
                                                  //| u zsm jegkz foqbtgxtwa.
  mkSentence()                                    //> res10: String = Bvixt kxs tbefz xg ekr xvguh kdnk hy cqa vpirmhfbh pqvfuitr
                                                  //| me.
  mkSentence()                                    //> res11: String = Nlc tdghtk eljgdkyqb ydqvmee bc opchxq exqfoz xluvzo drwpco
                                                  //| f fo wqpti.

  /** Problem 7 */
  // Check peano.scala
}