package expression
import context._
import value._

trait Expression {
  def execute(env: Environment): Value // Abstract method
  
}