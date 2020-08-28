package acorn

object TestAcorn extends App {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(123); 
   var exp: Expression = Sum(Number(42), Product(Number(3.14), Number(2.71)));System.out.println("""exp  : acorn.Expression = """ + $show(exp ));$skip(56); 
   println("the value of " + exp + " = " + exp.execute);$skip(59); 
   exp = Product(Number(2), Product(Number(3), Number(5)));$skip(56); 
   println("the value of " + exp + " = " + exp.execute)}
}
