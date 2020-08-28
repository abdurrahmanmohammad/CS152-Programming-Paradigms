package mathematics

object poly {

  def roots(p: (Double, Double, Double)): Option[(Double, Double)] = {
    // Strategy: Solve using the quadratic formula
    try { // = Some((r1, r2)) where p(r1) == p(r2) == 0
      val sqrtdet = math.sqrt(p._2 * p._2 - 4 * p._1 * p._3) // sqrt(b^2 - 4ac)
      Option((-p._2 + sqrtdet) / (2 * p._1), (-p._2 - sqrtdet) / (2 * p._1))
    } catch { // If the root is imaginary
      case e: Exception => None // = None if p has no real roots
    }
  }

  def deriv(p: (Double, Double, Double)): (Double, Double, Double) =
    (0, p._1 * 2, p._2) // = derivative of p (which should be degree 1)

  def eval(a: Double, p: (Double, Double, Double)): Double =
    p._1 * a * a + p._2 * a + p._3 // = p(a)
}