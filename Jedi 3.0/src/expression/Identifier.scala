package expression
// Completed: Jedi 2.1 (Given in lecture)
// Completed: Jedi 1.0 (Given in lecture)
import context._
import value._

case class Identifier(val name: String) extends Expression {
  override def toString = name

  def head = this

  override def equals(other: Any) =
    if (!other.isInstanceOf[Identifier]) false
    else this.name == other.asInstanceOf[Identifier].name

  def execute(env: Environment) = // Identifier.execute
    env(this) match { // Takes this and looks it up in the environment
      case thunk: Thunk => thunk(env) // If returns type thunk, call thunk.apply
      case text: Text   => text(env) // If returns type text, call text.apply and pass in this environment
      case value: Value => value // In case it is any other value, return the value
    }
}

// env is a hashmap
// you can call hashmap like a function