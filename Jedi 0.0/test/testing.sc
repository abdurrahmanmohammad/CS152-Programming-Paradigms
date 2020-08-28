package test
import context._
import expression._
import value._

object testing {
  // BooleTest
  val t = Boole(true)                             //> t  : value.Boole = true
  val f = Boole(false)                            //> f  : value.Boole = false
  println("t && f = " + (t && f))                 //> t && f = false
  println("t || f = " + (t || f))                 //> t || f = true
  println("!t = " + (!t))                         //> !t = false

  // CharsTest
  val s1 = Chars("California")                    //> s1  : value.Chars = California
  val s2 = Chars("...")                           //> s2  : value.Chars = ...
  val s3 = Chars("Dreaming")                      //> s3  : value.Chars = Dreaming
  val s4 = s1 + s2 + s3                           //> s4  : value.Chars = California...Dreaming
  val s5 = Chars("California")                    //> s5  : value.Chars = California

  println("s4 = " + s4)                           //> s4 = California...Dreaming

  println(s4.substring(Integer(3), Integer(8)))   //> iforn
  "California...Dreaming".substring(3,8)          //> res0: String = iforn

  println(s1 + " < " + s3 + " = " + (s1 < s3))    //> California < Dreaming = true
  "California" < "Dreaming"                       //> res1: Boolean = true
  println(s1 + " == " + s5 + " = " + (s1 == s5))  //> California == California = true
  // Additional Test
  "cat" < "dog"                                   //> res2: Boolean = true
  def animal = "cat" + "fish"                     //> animal: => String
  animal                                          //> res3: String = catfish
  animal == "catfish"                             //> res4: Boolean = true

  // ExpTest
  val globalEnv = new Environment                 //> globalEnv  : context.Environment = Map()
  val pi = Identifier("pi")                       //> pi  : expression.Identifier = pi
  val num = Real(3.14)                            //> num  : value.Real = 3.14
  globalEnv.put(pi, num)                          //> res5: Option[value.Value] = None
  println(pi.execute(globalEnv))                  //> 3.14
  println(num.execute(globalEnv))                 //> 3.14

  // NumberTest1
  var i1 = Integer(7)                             //> i1  : value.Integer = 7
  var i2 = Integer(6)                             //> i2  : value.Integer = 6
  println("i1 * i2 = " + (i1 * i2))               //> i1 * i2 = 42
  println("i1 == i2 = " + (i1 == i2))             //> i1 == i2 = false
  println("i1 < i2 = " + (i1 < i2))               //> i1 < i2 = false
  println("i1.## = " + i1.##)                     //> i1.## = 55

  var r1 = Real(3.14)                             //> r1  : value.Real = 3.14
  var r2 = Real(2.71)                             //> r2  : value.Real = 2.71
  println("-r1 = " + -r1)                         //> -r1 = -3.14
  println("r1 * r2 = " + (r1 * r2))               //> r1 * r2 = 8.5094
  println("r1 == r2 = " + (r1 == r2))             //> r1 == r2 = false
  println("r1 < r2 = " + (r1 < r2))               //> r1 < r2 = false
  println("r1.## = " + r1.##)                     //> r1.## = 1565118

  println("r1 * i2 = " + (r1 * i2))               //> r1 * i2 = 18.84
  println("i1 * r2 = " + (i1 * r2))               //> i1 * r2 = 14
}