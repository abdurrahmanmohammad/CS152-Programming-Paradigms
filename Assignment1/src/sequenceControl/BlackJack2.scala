package sequenceControl
import scala.util._
object BlackJack2 extends App {
  val gen = new Random(System.currentTimeMillis())
  val cards = new Array[Int](52)
  for (i <- 0 until 52) cards(i) = if (gen.nextBoolean()) gen.nextInt(11) else -1
  var total = 0
  // iterate through cards incrementing total, use break to continue and break

  try {
    for (i <- 0 until 52) {
      try {
        if (cards(i) <= 0) throw new Exception
        total += cards(i)
      } catch {
        case _: Throwable => // no op
      }
      if (21 <= total) throw new Exception
    }
  } catch {
    case _: Throwable => // no op
  }
  println("total = " + total)
}