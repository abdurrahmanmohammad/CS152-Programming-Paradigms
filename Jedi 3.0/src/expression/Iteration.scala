package expression
import context._
import value._
// Completed: Jedi 3.0 (Myself)
case class Iteration(val conditional: Expression, val body: Expression) extends SpecialForm {
  def execute(env: Environment) = {
    while (conditional.execute(env) == Boole(true)) body.execute(env)
    Notification.DONE
  }
}