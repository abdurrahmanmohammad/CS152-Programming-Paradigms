package context
// Completed: Jedi 3.0 (Myself)
// Completed: Jedi 1.0 (Mostly given and modified)
import expression._
import value._

/*
 * Notes:
 * alu implements all low-level arithmetic, logic, and I/O functions
 * alu does lots of type checking
 * alu is a singleton
 */
object alu {
  // dispatcher
  def execute(opcode: Identifier, args: List[Value]): Value = {
    opcode.name match {
      case "add"         => add(args)
      case "mul"         => mul(args)
      case "sub"         => sub(args)
      case "div"         => div(args)
      case "less"        => less(args)
      case "more"        => more(args)
      case "equals"      => equals(args)
      case "unequals"    => unequals(args)
      case "not"         => not(args)
      // variables
      case "dereference" => dereference(args)
      case "var"         => makeVar(args)
      // primitive I/O ops:
      case "write"       => write(args)
      case "prompt"      => prompt(args)
      case "read"        => read(args)
      // store ops
      case "store"       => store(args)
      case "put"         => put(args)
      case "rem"         => rem(args)
      case "contains"    => contains(args)
      case "map"         => map(args)
      case "filter"      => filter(args)
      case "get"         => get(args)
      case "addLast"     => addLast(args)
      case "size"        => size(args)
      case _             => throw new UndefinedException(opcode)
    }
  }

  // variable ops

  // returns the content of args(0)
  private def dereference(args: List[Value]) = {
    if (args.length < 1) throw new TypeException("dereference expects one input")
    if (!args(0).isInstanceOf[Variable]) throw new TypeException("dereference expects Variable")
    args(0).asInstanceOf[Variable].content
  }

  // creates a new variable cobtaining args(0)
  private def makeVar(args: List[Value]) = {
    if (args.length < 1) throw new TypeException("makeVar expects one input")
    new Variable(args(0))
  }

  // store ops

  // returns a new store containing args
  private def store(args: List[Value]) = { new Store(args.to[collection.mutable.ArrayBuffer]) }

  // put(v: Value, p: Integer, s: Store) calls s.put(v, p)
  private def put(args: List[Value]) = {
    if (args.size != 3) throw new TypeException("expected signature: put(v: Value, p: Integer, s: Store)")
    if (!args(1).isInstanceOf[Integer] || !args(2).isInstanceOf[Store]) throw new TypeException("expected signature: put(v: Value, p: Integer, s: Store)")
    args(2).asInstanceOf[Store].put(args(0), args(1).asInstanceOf[Integer])
    Notification.DONE
  }

  // rem(p: Integer, s: Store) calls s.rem(p)
  private def rem(args: List[Value]) = {
    if (args.size != 2) throw new TypeException("expected signature: rem(p: Integer, s: Store)")
    if (!args(0).isInstanceOf[Integer] || !args(1).isInstanceOf[Store]) throw new TypeException("expected signature: rem(p: Integer, s: Store)")
    args(1).asInstanceOf[Store].rem(args(0).asInstanceOf[Integer])
    Notification.DONE
  }

  // get(p: Integer, s: Store) calls s.get(p)
  private def get(args: List[Value]) = {
    if (args.size != 2) throw new TypeException("expected signature: get(p: Integer, s: Store)")
    if (!args(0).isInstanceOf[Integer] || !args(1).isInstanceOf[Store]) throw new TypeException("expected signature: get(p: Integer, s: Store)")
    args(1).asInstanceOf[Store].get(args(0).asInstanceOf[Integer])
  }

  // map(f: Closure, s: Store) calls s.map(f)
  private def map(args: List[Value]) = {
    if (args.size != 2) throw new TypeException("expected signature: map(f: Closure, s: Store)")
    if (!args(0).isInstanceOf[Closure] || !args(1).isInstanceOf[Store]) throw new TypeException("expected signature: map(f: Closure, s: Store)")
    args(1).asInstanceOf[Store].map(args(0).asInstanceOf[Closure])
  }

  // filter(f: Closure, s: Store) calls s.filter(f)
  private def filter(args: List[Value]) = {
    if (args.size != 2) throw new TypeException("expected signature: filter(f: Closure, s: Store)")
    if (!args(0).isInstanceOf[Closure] || !args(1).isInstanceOf[Store]) throw new TypeException("expected signature: filter(f: Closure, s: Store)")
    args(1).asInstanceOf[Store].filter(args(0).asInstanceOf[Closure])
  }

  // contains(v: Value, s: Store) calls s.contains(v)
  private def contains(args: List[Value]) = {
    if (args.size != 2) throw new TypeException("expected signature: contains(v: Value, s: Store)")
    if (!args(0).isInstanceOf[Value] || !args(1).isInstanceOf[Store]) throw new TypeException("expected signature: contains(v: Value, s: Store)")
    args(1).asInstanceOf[Store].contains(args(0).asInstanceOf[Value])
  }

  // addLast(v: Value, s: Store) calls s.add(v)
  private def addLast(args: List[Value]) = {
    if (args.size != 2) throw new TypeException("expected signature: addLast(v: Value, s: Store)")
    if (!args(0).isInstanceOf[Value] || !args(1).isInstanceOf[Store]) throw new TypeException("expected signature: addLast(v: Value, s: Store)")
    args(1).asInstanceOf[Store].add(args(0).asInstanceOf[Value])
    Notification.DONE
  }

  // size(s: Store) calls s.size
  private def size(args: List[Value]) = {
    if (args.size != 1) throw new TypeException("expected signature: size(s: Store)")
    if (!args(0).isInstanceOf[Store]) throw new TypeException("expected signature: size(s: Store)")
    args(0).asInstanceOf[Store].size
  }

  private def toInt(arg: Value): Option[Integer] =
    if (arg.isInstanceOf[Integer]) Some(arg.asInstanceOf[Integer]) else None

  private def toReal(arg: Value): Option[Real] =
    if (arg.isInstanceOf[Real]) Some(arg.asInstanceOf[Real])
    else if (arg.isInstanceOf[Integer]) Some(Integer.intToReal(arg.asInstanceOf[Integer]))
    else None

  private def toChars(arg: Value): Option[Chars] =
    if (arg.isInstanceOf[Chars]) Some(arg.asInstanceOf[Chars]) else None

  private def add(args: List[Value]) = {
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) args2.flatten.reduce(_ + _)
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) args3.flatten.reduce(_ + _)
      else {
        val args4 = args.map(toChars).filter(_ != None)
        if (args4.size == args.size) args4.flatten.reduce(_ + _)
        else {
          throw new TypeException("Inputs to + must be numbers or texts")
        }
      }
    }
  }

  private def mul(args: List[Value]) = {
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) args2.flatten.reduce(_ * _)
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) args3.flatten.reduce(_ * _)
      else {
        throw new TypeException("Inputs to * must be numbers")
      }
    }
  }

  private def sub(args: List[Value]) = {
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) args2.flatten.reduce(_ - _)
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) args3.flatten.reduce(_ - _)
      else {
        throw new TypeException("Inputs to - must be numbers")
      }
    }
  }

  /*private def div(args: List[Value]) = {
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) args2.flatten.reduce(_ / _)
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) args3.flatten.reduce(_ / _)
      else {
        throw new TypeException("Inputs to / must be numbers")
      }
    }
  }*/
  private def div(args: List[Value]) = {
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) args2.flatten.reduce(_ / _)
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) args3.flatten.reduce(_ / _)
      else throw new TypeException("Inputs to / must be numbers")
    }
  }

  def less(args: List[Value]): Value = {
    if (args.length != 2) throw new TypeException("less expects two inputs")
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) Boole(args2(0) < args2(1))
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) Boole(args3(0) < args3(1))
      else {
        val args4 = args.map(toChars).filter(_ != None)
        if (args4.size == args.size) Boole(args4(0) < args4(1))
        else throw new TypeException("Inputs to < must be numbers or texts")
      }
    }
  }

  def more(args: List[Value]): Value = {
    if (args.length != 2) throw new TypeException("more expects two inputs")
    val args2 = args.map(toInt).filter(_ != None)
    if (args2.size == args.size) Boole(args2(0) > args2(1))
    else {
      val args3 = args.map(toReal).filter(_ != None)
      if (args3.size == args.size) Boole(args3(0) > args3(1))
      else {
        val args4 = args.map(toChars).filter(_ != None)
        if (args4.size == args.size) Boole(args4(0) > args4(1))
        else throw new TypeException("Inputs to > must be numbers or texts")
      }
    }
  }

  /*def equals(args: List[Value]): Value = {
    if (args.length < 2) throw new TypeException("equals expects two or more inputs")
    def reduce(unseen: List[Boolean]): Boole = { // Reduces all boolean vals in list to 1
      if (unseen.contains(false)) Boole(false) // Stop if there is a false in list
      else if (unseen.size > 1) reduce(args.map(_ == args.head).tail) // If size is >1, reduce further
      else Boole(unseen.head) // If size == 1, return the only boolean val
    }
    reduce(args.map(_ == args.head)) // Convert all values to boolean (by comparing head with elements) and reduce
  }*/
  private def equals(args: List[Value]): Value = {
    var result = true
    for (i <- 1 until args.length if result) {
      result = (args(0) == args(i))
    }
    Boole(result)
  }

  /*def unequals(args: List[Value]): Value = {
    if (args.length < 2) throw new TypeException("unequals expects two or more inputs")
    else not(List(equals(args)))
  }*/
  private def unequals(args: List[Value]): Value = {
    if (args.length != 2) throw new TypeException("unequals expects two inputs")
    !(equals(args).asInstanceOf[Boole])
  }

  private def not(args: List[Value]) = {
    if (args.length != 1) throw new TypeException("not expects 1 input")
    if (args.head.isInstanceOf[Boole]) !args(0).asInstanceOf[Boole] // Arg must be of type Boole (not should not work on other types)
    else throw new TypeException("not expects boole")
  }

  def write(vals: List[Value]): Value = { println(vals(0)); Notification.DONE }
  def read(vals: List[Value]): Value = { val result = io.StdIn.readDouble(); Real(result) }
  def prompt(vals: List[Value]): Value = { print("=> "); Notification.DONE }

  // etc.
}