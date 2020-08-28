package expression
// Completed: Jedi 0.0 (Given)
import context._
import value._

trait Expression {
  def execute(env: Environment): Value // Abstract method
}