package cl.uchile.dcc
package gwent.cards

import java.util.Objects

/** An abstract Class that represent a Combat Card
 * 
 * @param name The name of the card
 * @param damage The damage value of the card
 * @param combatType Represent if the card is Melee, Ranged or Siege
 *                   
 *  @constructor Creates a Combat Card with a name, a specific damage, and combat type
 */

abstract class AbstractCombatCard protected (val name: String, val description: String,
                                   val damage: Int) extends Card {


  /** A method that represents the curren damage of a card, after buffs or debuffs
   *  the initial current power is the card damage
   *
   * @return the current damage
   */
  def currentPower: Int = damage





  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[AbstractCombatCard]) {
      // We check if the objects class are the same

      val other = obj.asInstanceOf[AbstractCombatCard]
      //  We verify if the object are equal by reference.
      (this eq other) ||
        // 3. We verify if the objects attributes and values are equal.
        (this.name == other.name && this.description == other.description && this.damage == other.damage)
    } else {
      false
    }
  }
}

