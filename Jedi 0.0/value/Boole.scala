package value

import expression._
import context._
case class Boole(val value: Boolean) extends Literal with Equals {
  def unary_! = Boole(!(this.value)) // Given
  def &&(other: Boole) = Boole(this.value && other.value) // Given
  def ||(other: Boole) = Boole(this.value || other.value) // Given

  override def toString = value.toString
  /*
  // Customized compare method
  def compare(other: Boole): Int = {
    val thisVal = if (this.value == true) 1 else 0 // true = 1, false = 0
    val otherVal = if (this.value == true) 1 else 0 // true = 1, false = 0
    if (thisVal < otherVal) -1 else if (otherVal < thisVal) 1 else 0
  }
  */
  override def canEqual(other: Any) = other.isInstanceOf[Boole]
  override def equals(other: Any): Boolean =
    other match {
      case other: Boole => this.canEqual(other) && (other.value == this.value)
      case _ => false
    }
  override def hashCode = this.toString.##
}

// Status: Finished