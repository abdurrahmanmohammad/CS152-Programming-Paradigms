package expression

import context.Environment

case class Identifier(val name: String) extends Expression {
   override def toString = name
   def execute(env: Environment) = env(this)
}

// Status: Somewhat Finished

// env is a hashmap
// you can call hashmap like a function
// Finished