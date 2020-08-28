package expression
// Completed: Jedi 1.0 (Given in lecture)
import value._
import context._

case class Declaration(val name: Identifier, val body: Expression) extends SpecialForm {
  def execute(env: Environment) = {
    env(name) = body.execute(env)
    Notification.OK // Changed from DONE to OK
  }
}

// For example: def x = add(2, 3)
// Code given out exactly like this on 4/9/20