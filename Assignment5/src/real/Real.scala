package real

class Real(val scalaValue: Double) extends Ordered[Real] with Equals {
  def *(other: Real) = Real(this.scalaValue * other.scalaValue)
  def +(other: Real) = Real(this.scalaValue + other.scalaValue)
  def -(other: Real) = Real(this.scalaValue - other.scalaValue)
  def /(other: Real) = Real(this.scalaValue / other.scalaValue)

  override def compare(other: Real): Int = this.scalaValue.compare(other.scalaValue)

  override def equals(other: Any): Boolean =
    other match {
      case other: Real => this.canEqual(other) && other.scalaValue == scalaValue
      case _ => false
    }

  override def canEqual(other: Any): Boolean = other.isInstanceOf[Real]
}

object Real {
  def apply(scalaValue: Double) = new Real(scalaValue)
}

object RealTest extends App {
  var r1 = Real(3.14)
  var r2 = Real(2.71)
  println("r1 * r2 = " + (r1 * r2))
  println("r1 == r2 = " + (r1 == r2))
  println("r1 < r2 = " + (r1 < r2))
}
