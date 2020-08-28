package expression
// Completed: Jedi 3.0 (Myself)
import context._
import value._

case class Assignment(val variable: Identifier, val update: Expression) extends SpecialForm {
  def execute(env: Environment) = {
    env(variable).asInstanceOf[Variable].content = update.execute(env)
    Notification.DONE
  }
}