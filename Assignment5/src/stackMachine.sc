import scala.collection.immutable._

object stackMachine {
  /** A stack machine is a simple computer containing a stack of integers and a program. */
  object StackMachine {
    var stack: List[Int] = Nil // A stack of integers
    var program: List[Command] = Nil // A program is a list of commands.
    def run() { // When the stack machine runs, each command in the program is executed.
      for (instruction <- program) instruction.execute()
    }
  }

  trait Command {
    def execute()
  }
  /** Most commands update the stack when executed. */

  class Push(val arg: Int) extends Command {
    override def execute() = StackMachine.stack = StackMachine.stack :+ arg // // pushes arg onto stack
  }
  object Push {
    def apply(arg: Int) = new Push(arg)
  }

  class Pop() extends Command {
    override def execute() = StackMachine.stack = StackMachine.stack.tail // removes the stack's top element

  }
  object Pop {
    def apply() = new Pop()
  }

  class Top() extends Command {
    override def execute() = println(StackMachine.stack.last) // prints the stack's top element (without removing it)
  }
  object Top {
    def apply() = new Top()
  }

  class Sum() extends Command {
    override def execute() = {
      val num1 = StackMachine.stack.last // Get last element
      StackMachine.stack = StackMachine.stack.dropRight(1) // Remove last element
      val num2 = StackMachine.stack.last // Get last element
      StackMachine.stack = StackMachine.stack.dropRight(1) // Remove last element
      StackMachine.stack = StackMachine.stack :+ num1 + num2 // replaces the top two elements of the stack by their sum
    }
  }
  object Sum {
    def apply() = new Sum()
  }

  class Times() extends Command {
    override def execute() = {
      val num1 = StackMachine.stack.last // Get last element
      StackMachine.stack = StackMachine.stack.dropRight(1) // Remove last element
      val num2 = StackMachine.stack.last // Get last element
      StackMachine.stack = StackMachine.stack.dropRight(1) // Remove last element
      StackMachine.stack = StackMachine.stack :+ num1 * num2 // replaces the top two elements of the stack by their product
    }
  }
  object Times {
    def apply() = new Times()
  }
  // ---------- Sample Run ----------
  StackMachine.program = List(Push(3), Push(4), Push(5), Sum(), Times(), Top())
  StackMachine.run()                              //> 27

  StackMachine.program = List(Push(10), Push(10), Times(), Push(20), Sum(), Top())
  StackMachine.run()                              //> 120

}