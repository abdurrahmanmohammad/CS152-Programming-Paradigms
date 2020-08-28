package expression
// Completed: Jedi 1.0 (In Solutions)
import context._
import value._
case class Disjunction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment) = {
    var result = false
    for (exp <- operands if !result) {
      val arg = exp.execute(env)
      if (!arg.isInstanceOf[Boole]) throw new TypeException("Disjunction operands must be Booles")
      result = arg.asInstanceOf[Boole].value
    }
    Boole(result)
  }
}

/*case class Disjunction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment): Boole = {
    if (operands.size < 2) throw new TypeException("Disjunction needs 2 or more expressions")
    def helper(result: Boole, unseen: List[Expression]): Boole = {
      if (unseen == Nil) result
      else {
        val current = unseen.head.execute(env) // Execute expression
        if (!current.isInstanceOf[Boole]) throw new TypeException("Conjunction requires Boole") // Check return type. If not Boole, throw exception
        else if (current.asInstanceOf[Boole].value) helper(Boole(true), Nil) // If expression is true, change result to true and stop searching (Nil)
        else helper(result, unseen.tail) // If expression is false, check next expression
      }
    }
    helper(Boole(false), operands)
  }
}*/