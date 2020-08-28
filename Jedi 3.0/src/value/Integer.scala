package value
// Completed: Jedi 0.0 (Given)
import expression._
import context._

case class Integer(val value: Int) extends Literal with Ordered[Integer] with Equals {
  def +(other: Integer) = Integer(this.value + other.value)
  // *, -, /
  def -(other: Integer) = Integer(this.value - other.value)
  def *(other: Integer) = Integer(this.value * other.value)
  def /(other: Integer) = if (other.value == 0) throw new Exception("Divide By 0 Exception") else Real(this.value / other.value)
  def unary_- = Integer(-this.value) // unary negation
  override def toString = value.toString
  def compare(other: Integer): Int = if (this.value < other.value) -1 else if (other.value < this.value) 1 else 0
  override def canEqual(other: Any) = other.isInstanceOf[Integer]
  override def equals(other: Any): Boolean =
    other match {
      case other: Integer => this.canEqual(other) && (other.value == this.value)
      case _              => false
    }
  override def hashCode = this.toString.##
}

object Integer {
  implicit def intToReal(n: Integer): Real = Real(n.value.toDouble)
}

// All value classes must be case classes
// For Real, copy and replace all integer with real