package value
// Completed: Jedi 0.0 (Given)
class Notification(val name: String) extends Value {
  override def toString = name
}

object Notification {
  def apply(message: String) = new Notification(message) // Apply method
  // Different Notifications: OK, DONE, UNSPECIFIED
  val OK = new Notification("OK")
  val DONE = new Notification("DONE")
  val UNSPECIFIED = new Notification("UNSPECIFIED")
}

 // -> def pi = 3.14 // updates environment
 // OK
// Expression mathods must be case classes