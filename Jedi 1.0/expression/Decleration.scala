package expression
import value._
import context._

// For example: def x = add(2, 3)
case class Declaration(val name: Identifier, val body: Expression) extends SpecialForm {
  def execute(env: Environment) = {
    env(name) = body.execute(env)
    Notification.OK // Changed from DONE to OK
  }
}

// Completed: 4/9
