package value
// Completed: Jedi 2.1 (Given in lecture)
import context._
import expression._

class Closure(params: List[Identifier], body: Expression, defEnv: Environment) extends Value {
  
  override def toString = "closure"
  
  def apply(args: List[Value], callEnv: Environment = null): Value = {
    val tempEnv =
      if (flags.staticScope) new Environment(defEnv) // Extends the defining environment
      else new Environment(callEnv) // The calling environment is extended by the temporary environment.
    tempEnv.bulkPut(params, args) // Bind params to args in tempEnv (hint use bulkPut)
    body.execute(tempEnv) // Execute the body relative to the temporary environment
  }
}

/*
 * To implement this the apply method of Closure needs the calling environment as an extra parameter. 
 * (This must be passed in by FunCall's execute method.) 
 * The calling environment instead of the defining environment is extended by the temporary environment.
 * 
 * Setting the static scope rule flag to false means closures are executed using their calling environments rather than their defining environments. 
 * This can produce some undesirable results
 */

/*
// Completed: Jedi 2.0 (Given in lecture)
class Closure(params: List[Identifier], body: Expression, defEnv: Environment) extends Value {
  def apply(args: List[Value]): Value = {
    val tempEnv = new Environment(defEnv) // Extends the defining environment
    tempEnv.bulkPut(params, args) // Bind params to args in tempEnv (hint use bulkPut)
    body.execute(tempEnv) // Execute the body relative to the temporary environment
  }
}
*/