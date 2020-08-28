package acorn

abstract class Expression {
  def execute: Double
}
class Sum(val operand1: Expression, val operand2: Expression) extends Expression {
  def execute = operand1.execute + operand2.execute
  override def toString = "(+ " + operand1 + " " + operand2 + ")"
}

object Sum {
  def apply(operand1: Expression, operand2: Expression) = new Sum(operand1, operand2)
}
/** ---------- My Implementation Start ---------- */
class Number(val number: Double) extends Expression {
  def execute = number
  override def toString: String = number.toString
}

object Number {
  def apply(number: Double) = new Number(number)
}

// Similar to sum, but replace all '+' with '*'
class Product(val operand1: Expression, val operand2: Expression) extends Expression {
  def execute = operand1.execute * operand2.execute
  override def toString: String = "(* " + operand1 + " " + operand2 + ")"
}

object Product {
  def apply(operand1: Expression, operand2: Expression) = new Product(operand1, operand2)
}
  /** ---------- My Implementation End ---------- */

