package expression
import context._
import value._

case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
  def execute(env: Environment): Value = {
    val arguments: List[Value] = operands.map(_.execute(env))
    alu.execute(operator, arguments)
  }
}

// Completed: 4/17
/**
 * // Code in lecture notes of 4/9 (ignore)
 * class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
 * 	def execute(env: Environment) = Notification.Unspecified
 * }
 */