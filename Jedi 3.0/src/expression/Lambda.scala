package expression
// Completed: Jedi 2.0 (Given in lecture)
import context._
import value._

case class Lambda(params: List[Identifier], body: Expression) extends SpecialForm {
  override def execute(env: Environment): Value = new Closure(params, body, env)
}