package recognizers

object RecognizerTests {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(147); 

  // exp1 ::= 00 ~ 11 | 111
  def exp1 = pipe(follows(matches("00"), matches("11")), matches("111"));System.out.println("""exp1: => <error>""");$skip(34); 
  println(exp1("0011"));$skip(34);  // = true
  println(exp1("111"));$skip(51);   // = true
  println(exp1("000011")) // = false, too many 0's}


}
