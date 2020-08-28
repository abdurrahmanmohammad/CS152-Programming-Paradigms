package test
import context._
import expression._
import value._

object testing {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(119); 
  // BooleTest
  val t = Boole(true);System.out.println("""t  : value.Boole = """ + $show(t ));$skip(23); 
  val f = Boole(false);System.out.println("""f  : value.Boole = """ + $show(f ));$skip(34); 
  println("t && f = " + (t && f));$skip(34); 
  println("t || f = " + (t || f));$skip(26); 
  println("!t = " + (!t));$skip(47); 

  // CharsTest
  val s1 = Chars("California");System.out.println("""s1  : value.Chars = """ + $show(s1 ));$skip(24); 
  val s2 = Chars("...");System.out.println("""s2  : value.Chars = """ + $show(s2 ));$skip(29); 
  val s3 = Chars("Dreaming");System.out.println("""s3  : value.Chars = """ + $show(s3 ));$skip(24); 
  val s4 = s1 + s2 + s3;System.out.println("""s4  : value.Chars = """ + $show(s4 ));$skip(31); 
  val s5 = Chars("California");System.out.println("""s5  : value.Chars = """ + $show(s5 ));$skip(25); 

  println("s4 = " + s4);$skip(49); 

  println(s4.substring(Integer(3), Integer(8)));$skip(41); val res$0 = 
  "California...Dreaming".substring(3,8);System.out.println("""res0: String = """ + $show(res$0));$skip(48); 

  println(s1 + " < " + s3 + " = " + (s1 < s3));$skip(28); val res$1 = 
  "California" < "Dreaming";System.out.println("""res1: Boolean = """ + $show(res$1));$skip(49); 
  println(s1 + " == " + s5 + " = " + (s1 == s5));$skip(37); val res$2 = 
  // Additional Test
  "cat" < "dog";System.out.println("""res2: Boolean = """ + $show(res$2));$skip(30); 
  def animal = "cat" + "fish";System.out.println("""animal: => String""");$skip(9); val res$3 = 
  animal;System.out.println("""res3: String = """ + $show(res$3));$skip(22); val res$4 = 
  animal == "catfish";System.out.println("""res4: Boolean = """ + $show(res$4));$skip(48); 

  // ExpTest
  val globalEnv = new Environment;System.out.println("""globalEnv  : context.Environment = """ + $show(globalEnv ));$skip(28); 
  val pi = Identifier("pi");System.out.println("""pi  : expression.Identifier = """ + $show(pi ));$skip(23); 
  val num = Real(3.14);System.out.println("""num  : value.Real = """ + $show(num ));$skip(25); val res$5 = 
  globalEnv.put(pi, num);System.out.println("""res5: Option[value.Value] = """ + $show(res$5));$skip(33); 
  println(pi.execute(globalEnv));$skip(34); 
  println(num.execute(globalEnv));$skip(40); 

  // NumberTest1
  var i1 = Integer(7);System.out.println("""i1  : value.Integer = """ + $show(i1 ));$skip(22); 
  var i2 = Integer(6);System.out.println("""i2  : value.Integer = """ + $show(i2 ));$skip(36); 
  println("i1 * i2 = " + (i1 * i2));$skip(38); 
  println("i1 == i2 = " + (i1 == i2));$skip(36); 
  println("i1 < i2 = " + (i1 < i2));$skip(30); 
  println("i1.## = " + i1.##);$skip(23); 

  var r1 = Real(3.14);System.out.println("""r1  : value.Real = """ + $show(r1 ));$skip(22); 
  var r2 = Real(2.71);System.out.println("""r2  : value.Real = """ + $show(r2 ));$skip(26); 
  println("-r1 = " + -r1);$skip(36); 
  println("r1 * r2 = " + (r1 * r2));$skip(38); 
  println("r1 == r2 = " + (r1 == r2));$skip(36); 
  println("r1 < r2 = " + (r1 < r2));$skip(30); 
  println("r1.## = " + r1.##);$skip(37); 

  println("r1 * i2 = " + (r1 * i2));$skip(36); 
  println("i1 * r2 = " + (i1 * r2))}
}
