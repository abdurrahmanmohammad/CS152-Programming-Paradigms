package gladiator

object tTestGladiator {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(343); 
  /**
   *  Create two gladiators:
   *  Optimus Prime of type CrusherMasher
   *  and Bumble Bee, a singleton that inherits from Gladiator, Slasher, and Masher and overrides the inherited attack method.
   */

  val maximus = new CrusherMasher("Optimus Prime") // Optimus Prime of type CrusherMasher
  object bee extends Gladiator("Bumble Bee") with Slasher with Masher { // Bumble Bee, a singleton that inherits from Gladiator, Slasher, and Masher
    override def attack(opponent: Gladiator) = { // overrides the inherited attack method
      super.attack(opponent)
      super.slash(opponent)
      super.mash(opponent)
    }
  };System.out.println("""maximus  : gladiator.CrusherMasher = """ + $show(maximus ));$skip(444); 

  /** Test your code as follows: */
  for (i <- 0 to 5) {
    maximus.attack(bee)
    bee.attack(maximus)
  }}
}
