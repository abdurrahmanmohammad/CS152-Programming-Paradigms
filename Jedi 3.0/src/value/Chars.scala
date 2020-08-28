package value
// Completed: Jedi 0.0 (Mostly given in lecture)
import expression._
import context._
case class Chars(val value: String) extends Literal with Ordered[Chars] with Equals {
  def +(other: Chars) = Chars(this.value + other.value)
  def ==(other: Chars) = this.value.equals(other.value)
  def substring(beginIndex: Integer, endIndex: Integer): Chars = Chars(value.substring(beginIndex.value, endIndex.value))
  override def toString = value
  def compare(other: Chars): Int = if (this.value < other.value) -1 else if (other.value < this.value) 1 else 0
  override def canEqual(other: Any) = other.isInstanceOf[Integer]
  override def equals(other: Any): Boolean =
    other match {
      case other: Integer => this.canEqual(other) && other.value.equals(this.value) // Need to use other.value.equals(this.value) for String
      case _ => false
    }
  override def hashCode = this.toString.##
}

// This class should support <, ==, substring, and + 
// < and == are done with the compare and equal methods