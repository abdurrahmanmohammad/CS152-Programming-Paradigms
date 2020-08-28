package stringProcessing
/** In collaboration with Muhammed Hussan Mahmood */
import scala.io._
class SyntaxException(gripe: String = "ERROR") extends Exception(gripe)
class MissingOperator extends SyntaxException("Missing operator!")
class NumberFormat extends SyntaxException("Illegal operand!")

object peano {
  def execute(cmmd: String): String = {
    // if cmmd is a valid expression, compute its value and return it as a string
    var index = 0
    var op1 = 0.0
    var op2 = 0.0
    var result = ""
    if (cmmd.indexOf('*') == -1 && cmmd.indexOf('+') == -1)
      println(new MissingOperator)
    else {
      index = cmmd.indexOf('*')
      if (index == -1)
        index = cmmd.indexOf('+')
      try {
        op1 = cmmd.slice(0, index).toDouble
        op2 = cmmd.slice(index + 1, cmmd.length).toDouble

        if (cmmd.charAt(index) == '+')
          result = (op1 + op2).toString
        else if (cmmd.charAt(index) == '*')
          result = (op1 * op2).toString

      } catch {
        case e: NumberFormatException => println(new NumberFormat)
      }
    }
    result
  }

  // read-execute-print loop
  def repl {
    println("Welcome to Peano 1.0")
    println("Enter an expression. e.g: 5 + 1")
    // repeatedly:
    //   1. prompt user for a string
    //   2. quit if cmmd == "quit"
    //   3. ignore if cmmd == ""
    //   4. print execute(cmmd) otherwise
    //   5. handle all exceptions
    var continue = true
    var exp = ""

    do {
      exp = StdIn.readLine
      if (exp == "quit")
        continue = false
      else if (exp == "")
        continue = true
      else
        println(peano.execute(exp))

    } while (continue)
  }

  def main(args: Array[String]): Unit = {
    repl
  }
}
