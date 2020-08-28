package value
// Completed: Jedi 2.1 (Given in lecture)
import expression._
import context._
class Thunk(body: Expression, defEnv: Environment) extends Closure(Nil, body, defEnv) { // Has a body and a defining environment. Extends closure.
  private var cache: Value = null
  // For next feature
  /*def apply(callEnv: Environment) = {
    if (cache == null) cache = super.apply(Nil, callEnv) // If cache is empty, execute body relative to calling environment and store that in cache
    cache // Return value cache
  }*/
  def apply(callEnv: Environment) = {
    if (cache == null) cache = super.apply(Nil) // If cache is empty, call super.apply and store in cache
    cache // Return value cache
  }

}

/*object Thunk {
  
}*/