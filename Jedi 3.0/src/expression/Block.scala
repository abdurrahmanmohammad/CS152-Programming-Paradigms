package expression
// Completed: Jedi 2.0 (Myself)
import context._
import value._

case class Block(expressions: List[Expression]) extends SpecialForm {
  def execute(env: Environment): Value = {
    val tempEnv = new Environment(env)
    expressions.map(expression => expression.execute(tempEnv)).last
  }
}

// Create new local environment: new Environment(env)
// Execute all expressions in list by mapping them to a function that makes each expressoin execute itself
// Through mapping, values are stored in the existing list, so return the last stored value