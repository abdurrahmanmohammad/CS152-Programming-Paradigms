package gladiator

object tTestGladiator {
  /**
   *  Create two gladiators:
   *  Optimus Prime of type CrusherMasher
   *  and Bumble Bee, a singleton that inherits from Gladiator, Slasher, and Masher and overrides the inherited attack method.
   */

  val maximus = new CrusherMasher("Optimus Prime") // Optimus Prime of type CrusherMasher
                                                  //> maximus  : gladiator.CrusherMasher = gladiator.CrusherMasher@5ecddf8f
  object bee extends Gladiator("Bumble Bee") with Slasher with Masher { // Bumble Bee, a singleton that inherits from Gladiator, Slasher, and Masher
    override def attack(opponent: Gladiator) = { // overrides the inherited attack method
      super.attack(opponent)
      super.slash(opponent)
      super.mash(opponent)
    }
  }

  /** Test your code as follows: */
  for (i <- 0 to 5) {
    maximus.attack(bee)
    bee.attack(maximus)
  }                                               //> Attacker: Optimus Prime		Victim: Bumble Bee
                                                  //| Crushing: Bumble Bee
                                                  //| Mashing: Bumble Bee
                                                  //| Attacker: Bumble Bee		Victim: Optimus Prime
                                                  //| Slashing: Optimus Prime
                                                  //| Mashing: Optimus Prime
                                                  //| Attacker: Optimus Prime		Victim: Bumble Bee
                                                  //| Crushing: Bumble Bee
                                                  //| Mashing: Bumble Bee
                                                  //| Attacker: Bumble Bee		Victim: Optimus Prime
                                                  //| Dead gladiators don't fight!
                                                  //| Dead gladiators don't fight!
                                                  //| Dead gladiators don't fight!
                                                  //| Crushing: Bumble Bee
                                                  //| Mashing: Bumble Bee
                                                  //| Dead gladiators don't fight!
                                                  //| Dead gladiators don't fight!
                                                  //| Dead gladiators don't fight!
                                                  //| Dead gladiators don't fight!
                                                  //| Crushing: Bumble Bee
                                                  //| Mashing: Bumble Bee
                                                  //| Dead gladiators don't fight!
                                                  //| Dead gladiators don't fight!
                                                  //| Dead gladiators don't fight!
                                                  //| Dead gladiators don't fight!
                                                  //| Crushing: Bumble Bee
                                                  //| Mashing: Bumble Bee
                                                  //| Dead gladiators don't fight!
                                                  //| Dead gladiators don't fight!
                                                  //| Dead gladiators don't fight!
                                                  //| Dead gladiators don't fight!
                                                  //| Crushing:
                                                  //| Output exceeds cutoff limit.
}