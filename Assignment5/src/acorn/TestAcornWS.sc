package acorn

object TestAcornWS {
  var exp: Expression = Sum(Number(42), Product(Number(3.14), Number(2.71)))
                                                  //> exp  : acorn.Expression = (+ 42.0 (* 3.14 2.71))
  println("the value of " + exp + " = " + exp.execute)
                                                  //> the value of (+ 42.0 (* 3.14 2.71)) = 50.5094
  exp = Product(Number(2), Product(Number(3), Number(5)))
  println("the value of " + exp + " = " + exp.execute)
                                                  //> the value of (* 2.0 (* 3.0 5.0)) = 30.0
}