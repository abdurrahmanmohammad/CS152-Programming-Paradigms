package recognizers

object TestRecognizers extends App with Recognizers {
  // exp1 ::= 00 ~ 11 | 111
  def exp1 = pipe(follows(matches("00"), matches("11")), matches("111"))
  println(exp1("0011")) // = true
  println(exp1("111")) // = true
  println(exp1("000011")) // = false, too many 0's
  
  // Test your implementation by using your combinators to create a recognizer exp for the pattern
  // ((00) ~ (111)* ~ (00)?) | (11111).
  def exp = pipe(follows(follows(matches("00"), rep(matches("111"))), opt(matches("00"))), matches("11111"))
  println(exp("00111111"))
  println(exp("0011100"))
  println(exp("11111"))
  println(exp("110000011"))
}

