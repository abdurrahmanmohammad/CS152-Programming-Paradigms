package accumulator

import scala.collection.immutable._

object accumulator {
  /** An accumulator is a very simple computer. */
  object Accumulator {
    /**  It contains a single register and a program. */
    var register = 0 // Register
    var program: List[Instruction] = Nil // A program is a list of instructions.
    var HALT = false // Halt flag
    var IP = 0 // Instruction Pointer
    def run() {
      /** When the accumulator runs its program, each instruction is executed. */
      while (IP < program.length && HALT == false) {
        program(IP).execute() // Execute instruction at index IP
        IP += 1 // Increment IP after executing an instruction
      }
      IP = 0 // Reset IP after the program
    }
  }

  /** ---------- Problem 1 ---------- */
  /** Create a worksheet called accumulator. */
  /** Implement Accumulator and any other classes, objects, or traits you may need. */
  /** Test your implementation with the samples above. */
  trait Instruction {
    def execute()
  }

  class Add(val arg: Int) extends Instruction {
    override def execute() = Accumulator.register += arg
  }
  object Add {
    def apply(arg: Int) = new Add(arg)
  }

  class Mul(val arg: Int) extends Instruction {
    override def execute() = Accumulator.register *= arg
  }
  object Mul {
    def apply(arg: Int) = new Mul(arg)
  }

  /** ---------- Problem 2 ---------- */
  /** Add a Halt instruction to the accumulator in instruction set. */
  /** When executed, this instruction sets the HALT flag. The HALT flag is a new variable. */
  /** When set to true program execution immediately stops. */
  class Halt() extends Instruction {
    override def execute() = Accumulator.HALT = true // Sets the halt flag
  }
  object Halt {
    def apply() = new Halt()
  }

  /** ---------- Problem 3 ---------- */
  /** Add a Goto(arg) instruction to the accumulator in instruction set. */
  /** When executed, this instruction sets the instruction pointer (IP) to arg. */
  /** IP is a new variable that contains the index of the next instruction in the program to be executed. */
  class Goto(val arg: Int) extends Instruction {
    override def execute() = Accumulator.IP = arg - 1 // IP = arg. Dec. arg b.c. we inc. IP in while loop.

  }
  object Goto {
    def apply(arg: Int) = new Goto(arg: Int)
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(2416); 

  // computing ((3 * 5) + 1) * 2
  Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2));$skip(20); 
  Accumulator.run();$skip(23); val res$0 = 
  Accumulator.register;System.out.println("""res0: Int = """ + $show(res$0));$skip(63); 
  // computing (((10 * 2) + 3) * 5)
  Accumulator.register = 0;$skip(62); 
  Accumulator.program = List(Add(10), Mul(2), Add(3), Mul(5));$skip(20); 
  Accumulator.run();$skip(23); val res$1 = 
  Accumulator.register;System.out.println("""res1: Int = """ + $show(res$1));$skip(97); 

  // ---------- Test: Goto ----------
  // computing 10 * 2 + 3 = 23
  Accumulator.register = 0;$skip(80); 
  Accumulator.program = List(Add(10), Mul(2), Goto(5), Add(10), Mul(2), Add(3));$skip(20); 
  Accumulator.run();$skip(23); val res$2 = 
  Accumulator.register;System.out.println("""res2: Int = """ + $show(res$2));$skip(93); 

  // ---------- Test: Halt ----------
  // computing 10 * 2 = 20
  Accumulator.register = 0;$skip(79); 
  Accumulator.program = List(Add(10), Mul(2), Halt(), Add(10), Mul(2), Add(3));$skip(20); 
  Accumulator.run();$skip(23); val res$3 = 
  Accumulator.register;System.out.println("""res3: Int = """ + $show(res$3))}
}
