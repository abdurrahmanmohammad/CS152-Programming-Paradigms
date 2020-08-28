package test

import value._

object CharsTest extends App {
  
  val s1 = Chars("California")
  val s2 = Chars("...")
  val s3 = Chars("Dreaming")
  val s4 = s1 + s2 + s3
  val s5 = Chars("California")
  
  println("s4 = " + s4)
  
  println(s4.substring(Integer(3), Integer(8)))
  
  println(s1 + " < " + s3 + " = " + (s1 < s3))
  println(s1 + " == " + s5 + " = " + (s1 == s5))
  
}