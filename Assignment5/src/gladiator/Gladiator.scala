package gladiator

// **************************************************
/** ----- Gladiator ----- */
// **************************************************
/** A gladiator has a read-only name */
class Gladiator(val name: String) {
  /** And an integer health level which is initially 100 (this may not be initialized by users). */
  private var health_ : Int = 100
  /**
   * Health is decremented by a damage method
   * that takes an integer amount of damage as input
   * and decrements health by that amount.
   */
  /** However, health can never be negative. */
  def damage(damageAmt: Int) =
    if ((health_ - damageAmt) < 0) this.health_ = 0 // Health can never be negative
    else health_ -= damageAmt // Health is decremented by a damage method
  /** A gladiator has an attack method that has a gladiator opponent parameter. */
  /**
   * When called it simply prints the names of the attacker and the victim,
   * then damages the victim by a random amount less than the attacker's health
   * (because weak attackers can't do as much damage as healthy ones).
   */
  /** Note: both attacker and victim must have health > 0 in attack. */
  /** Dead gladiators don't fight! */
  def attack(opponent: Gladiator) =
    if (this.health_ <= 0 || opponent.health <= 0) println("Dead gladiators don't fight!")
    else {
      println("Attacker: " + this.name + "\t\t" + "Victim: " + opponent.name) // prints the names of the attacker and the victim
      val rand = new scala.util.Random
      opponent.damage(rand.nextInt(this.health_)) // then damages the victim by a random amount less than the attacker's health
    }

  /** Getter method for health */
  def health = health_
}

object Gladiator {
  def apply(name: String) = new Gladiator(name)
}

// **************************************************
/** ----- Traits: Slasher, Masher, and Crusher ----- */
// **************************************************
trait Crusher {
  /** Describes the crushing then decrements the opponents health by 5 points. */
  def crush(opponent: Gladiator) = {
    if (opponent.health <= 0) println("Dead gladiators don't fight!")
    else {
      println("Crushing: " + opponent.name) // Describes the crushing
      opponent.damage(5) // decrements the opponents health by 5 points
    }
  }
}

trait Masher {
  /** Describes the mashing then decrements the opponents health by 5 points. */
  def mash(opponent: Gladiator) = {
    if (opponent.health <= 0) println("Dead gladiators don't fight!")
    else {
      println("Mashing: " + opponent.name) // Describes the mashing
      opponent.damage(5) // decrements the opponents health by 5 points
    }
  }
}

trait Slasher {
  /** Describes the slashing then decrements the opponents health by 5 points. */
  def slash(opponent: Gladiator) = {
    if (opponent.health <= 0) println("Dead gladiators don't fight!")
    else {
      println("Slashing: " + opponent.name) // Describes the slashing
      opponent.damage(5) // decrements the opponents health by 5 points
    }
  }
}

// **************************************************
/** --------------- CrusherMasher --------------- */
// **************************************************
/** A CrusherMasher inherits from Gladiator, Crusher, and Masher. */
class CrusherMasher(name: String) extends Gladiator(name) with Crusher with Masher {
  override def attack(opponent: Gladiator) = {
    /** It overrides attack */
    super.attack(opponent)
    /** calls the inherited attack */
    super.crush(opponent)
    /** then calls the inherited crush */
    super.mash(opponent)
    /** and mash methods. */
  }
}
object CrusherMasher {
  def apply(name: String) = new CrusherMasher(name)
}



