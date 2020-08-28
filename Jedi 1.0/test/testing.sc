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
  val globalEnv = new Environment                 //> java.lang.NoClassDefFoundError: context/Environment
                                                  //| 	at test.testing$.$anonfun$main$1(test.testing.scala:36)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$anonfun$$ex
                                                  //| ecute$1(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:76)
                                                  //| 	at test.testing$.main(test.testing.scala:6)
                                                  //| 	at test.testing.main(test.testing.scala)
                                                  //| Caused by: java.lang.ClassNotFoundException: context.Environment
                                                  //| 	at java.net.URLClassLoader.findClass(URLClassLoader.java:382)
                                                  //| 	at java.lang.ClassLoader.loadClass(ClassLoader.java:418)
                                                  //| 	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:355)
                                                  //| 	at java.lang.ClassLoader.loadClass(ClassLoader.java:351)
                                                  //| 	... 6 more
  val pi = Identifier("pi")
  val num = Real(3.14)
  globalEnv.put(pi, num)
  println(pi.execute(globalEnv))
  println(num.execute(globalEnv))

  // NumberTest1
  var i1 = Integer(7)
  var i2 = Integer(6)
  println("i1 * i2 = " + (i1 * i2))
  println("i1 == i2 = " + (i1 == i2))
  println("i1 < i2 = " + (i1 < i2))
  println("i1.## = " + i1.##)

  var r1 = Real(3.14)
  var r2 = Real(2.71)
  println("-r1 = " + -r1)
  println("r1 * r2 = " + (r1 * r2))
  println("r1 == r2 = " + (r1 == r2))
  println("r1 < r2 = " + (r1 < r2))
  println("r1.## = " + r1.##)

  println("r1 * i2 = " + (r1 * i2))
  println("i1 * r2 = " + (i1 * r2))
}