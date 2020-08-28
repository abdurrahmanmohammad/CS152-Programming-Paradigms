package acorn

object TestAcornWS {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(112); 
  var exp: Expression = Sum(Number(42), Product(Number(3.14), Number(2.71)));System.out.println("""exp  : acorn.Expression = """ + $show(exp ));$skip(55); 
  println("the value of " + exp + " = " + exp.execute);$skip(58); 
  exp = Product(Number(2), Product(Number(3), Number(5)));$skip(55); 
  println("the value of " + exp + " = " + exp.execute)}
}
