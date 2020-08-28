package value

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

// Status: Finished
// 
/*
 -> def pi = 3.14 // updates environment
 * ok
 */

// Expression mathods must be case classes