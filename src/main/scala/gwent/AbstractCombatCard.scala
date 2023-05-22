package cl.uchile.dcc
package gwent
import java.util.Objects

/** An abstract Class tha represent a Combat Card 
 * 
 * @param name The name of the card
 * @param damage The damage value of the card
 * @param combatType Represent if the card is Melee, Ranged or Siege
 *                   
 *  @constructor Creates a Combat Card with a name, a specific damage, and combat type
 */

abstract class AbstractCombatCard (name: String, val description: String, val damage: Int)
  extends Card {


  def currentPower: Int = damage

  override def equals(obj: Any): Boolean = obj match { // if two card have the same name, they are the same
    // the damage doesn-t matter cause it can change
    case card: AbstractCombatCard => this.name == card.name && this.damage == card.damage && this.Cardtype == card.Cardtype
    case _ => false
  }


}