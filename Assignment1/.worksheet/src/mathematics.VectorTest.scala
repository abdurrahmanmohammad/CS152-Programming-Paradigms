package mathematics

object VectorTest extends App {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  val v1 = (2.0, 2.0, 2.0);System.out.println("""v1  : (Double, Double, Double) = """ + $show(v1 ));$skip(27); 
  val v2 = (1.0, 0.0, 0.0);System.out.println("""v2  : (Double, Double, Double) = """ + $show(v2 ));$skip(27); 
  val v3 = (0.0, 1.0, 0.0);System.out.println("""v3  : (Double, Double, Double) = """ + $show(v3 ));$skip(50); 

  println("sum(v3, v2) = " + vector.sum(v3, v2));$skip(47); 
  println("mul(3, v1) = " + vector.mul(3, v1));$skip(50); 

  println("dot(v1, v2) = " + vector.dot(v1, v2));$skip(49); 
  println("dot(v2, v3) = " + vector.dot(v2, v3));$skip(49); 
  println("dot(v1, v1) = " + vector.dot(v1, v1));$skip(48); 

  println("length(v1) = " + vector.length(v1));$skip(47); 
  println("length(v2) = " + vector.length(v2));$skip(54); 

  println("theta(v1, v2) = " + vector.theta(v1, v2));$skip(53); 
  println("theta(v3, v2) = " + vector.theta(v3, v2));$skip(35); 
  println("pi/2 = " + Math.PI / 2)}
}
