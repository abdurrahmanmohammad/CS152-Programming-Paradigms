package expression
// Completed: Jedi 2.1 (Given in lecture)
// Completed: Jedi 2.0 (Mostly given in lecture)
import context._
import value._

case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
  def execute(env: Environment): Value = {
    val args: List[Value] = flags.paramPassing match {
      case flags.BY_NAME  => operands.map(new Thunk(_, env))
      case flags.BY_TEXT  => operands.map(new Text(_))
      case flags.BY_VALUE => operands.map(_.execute(env))
    }
    if (env.contains(operator)) {
      operator.execute(env) match {
        case f: Thunk   => f(env)
        case f: Closure => f.apply(args, env)
        case _          => throw new TypeException("Only functions can be called")
      }
    } else {
      if (flags.paramPassing != flags.BY_VALUE) alu.execute(operator, operands.map(_.execute(env)))
      else alu.execute(operator, args)
    }
  }
}

/**
 * // Code in lecture notes of 4/9 (ignore)
 * class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
 * 	def execute(env: Environment) = Notification.Unspecified
 * }
 */
// Used for user-defined functions (closures which have a temp env)

    // Jedi 2.0
    /*val args: List[Value] = operands.map(_.execute(env)) // FunCall.execute begins by eagerly executing its operands to produce its arguments
    if (env.contains(operator) && env(operator).isInstanceOf[Closure]) {
      val closure = env(operator) // or operator.execute(env) - search for it - returns a closure
      closure.asInstanceOf[Closure](args) // bind parameters to args in tempEnv - closure.apply(args)
    } else alu.execute(operator, args)*/

// Better version
    //if (env.contains(operator) && env(operator).isInstanceOf[Closure]) env(operator).asInstanceOf[Closure](arguments)
    //else alu.execute(operator, arguments)

// env.contains(operator) 
  // checks to see if the operator/identifier exists first in the local scope then the extension (outer) scopes
  // Check if the environment (inner then outer scopes) contains the operator (in case of closure)
  // Check if it exists - not null Ex: x = 10; {x + 2} --> Must go outside to retrieve x so check if it exists inside first then outside
// env.apply(operator).isInstanceOf[Closure] 
  // check if it is a closure 
  // env.apply(operator) calls the super apply method of HashMap to return the value 
  // associated with the identifier which is a closure object - HashMap[Identifier, Value]
// env.apply(operator).asInstanceOf[Closure].apply(arguments) execute closure body
  // Identifiers are names of values. To execute an identifier we simply look it up in the environment.
