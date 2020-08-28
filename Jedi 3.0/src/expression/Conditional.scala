package expression
// Completed: Jedi 1.0 (Myself)
import context._
import value._

case class Conditional(val condition: Expression, val consequent: Expression, val alternative: Expression = null) extends SpecialForm {
  def execute(env: Environment): Value = {
    if (condition.execute(env).asInstanceOf[Boole].value) consequent.execute(env) // If it's true, execute the consequent and ignore the alternative
    else if (alternative == null) Notification.UNSPECIFIED // If it is null, return Notification.UNSPECIFIED and ignore the consequent
    else alternative.execute(env) // If it's false, execute the alternative (if it's not null)
  }
}