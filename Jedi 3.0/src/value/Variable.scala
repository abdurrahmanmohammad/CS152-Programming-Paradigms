package value
// Completed: Jedi 3.0 (Myself)
case class Variable(var content: Value) extends Value {
  override def toString = "[" + content + "]"
}