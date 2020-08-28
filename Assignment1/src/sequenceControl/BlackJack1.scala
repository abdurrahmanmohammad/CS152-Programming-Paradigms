package sequenceControl
import scala.util._
import util.control.Breaks._
object BlackJack1 extends App {
  val gen = new Random(System.currentTimeMillis())
  val cards = new Array[Int](52)
  for (i <- 0 until 52) cards(i) = if (gen.nextBoolean()) gen.nextInt(11) else -1
  var total = 0
  // iterate through cards incrementing total, use break to continue and break
  breakable {
    for (i <- 0 until 52) {
      breakable {
        if (cards(i) <= 0) break // Skip Jokers!
        total += cards(i)
      }
      if (21 <= total) break // Break out of main loop
    }
  }
  println("total = " + total)
}
