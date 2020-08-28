package value
// Completed: Jedi 2.1 (Given in lecture)
import expression._
import context._
class Text(val body: Expression) extends Value { // Text doesn't have a defining environment, has a calling environment
  private var cache: Value = null // Text has a cache
  def apply(callEnv: Environment) = {
    if (cache == null) cache = body.execute(callEnv) // If cache is empty, execute body relative to calling environment and store that in cache
    cache // Return value cache
  }
}