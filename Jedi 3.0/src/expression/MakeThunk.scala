package expression
// Completed: Jedi 2.1 (Myself)
import context._
import value._
case class MakeThunk(body: Expression) extends SpecialForm {
  override def execute(env: Environment): Value = new Thunk(body, env)
}