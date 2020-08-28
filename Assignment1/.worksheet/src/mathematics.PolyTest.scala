package mathematics

object PolyTest {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(66); 
  val p = (3.0, 9.0, -30.0);System.out.println("""p  : (Double, Double, Double) = """ + $show(p ));$skip(48); 
  
  println("eval(6, p) = " + poly.eval(6, p));$skip(45); 
  println("eval(2, p) = " + poly.eval(2, p));$skip(47); 
  println("eval(-5, p) = " + poly.eval(-5, p));$skip(44); 
  
  println("roots(p) = " + poly.roots(p));$skip(44); 
  
  println("deriv(p) = " + poly.deriv(p));$skip(54); 
  println("deriv2(p) = " + poly.deriv(poly.deriv(p)))}
}
