package cl.uchile.dcc
package gwent.cards

import gwent.cards.AbstractCombatCard

/** A class representing a Combat Ranged Card
 *
 * @param name The name of the card
 * @param damage The damage value of the card
 * @constructor Creates a Combat Card with a name, a specific damage, with a combatType Ranged
 */

class RangedCard (name: String, description: String, damage: Int) extends AbstractCombatCard(name,description, damage) {
  val Cardtype = "Ranged"
}
