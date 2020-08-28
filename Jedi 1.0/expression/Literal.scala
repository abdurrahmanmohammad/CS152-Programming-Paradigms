package expression

import value.Value
//import expression.Expression
import context.Environment

trait Literal extends Expression with Value {
  def execute(env: Environment): Value = this // A literal is its own value
}

// Status: Finished