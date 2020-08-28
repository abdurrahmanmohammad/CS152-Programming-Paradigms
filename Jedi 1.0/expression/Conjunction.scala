package expression
import context._
import value._

case class Conjunction(val operands: List[Expression]) extends SpecialForm {
  def execute(env: Environment): Boole = {
    if (operands.size < 2) throw new TypeException("Conjunction needs 2 or more expressions")
    def helper(result: Boole, unseen: List[Expression]): Boole = {
      if (unseen == Nil) result
      else {
        val current = unseen.head.execute(env) // Execute expression
        if (!current.isInstanceOf[Boole]) throw new TypeException("Conjunction requires Boole") // Check return type. If not Boole, throw exception
        else if (current.asInstanceOf[Boole].value) helper(result, unseen.tail) // If expression is true, proceed to next expression
        else helper(Boole(false), Nil) // If expression is false, change result to false and stop searching (Nil)
      }
    }
    helper(Boole(true), operands)
  }
}

// Completed: 4/17