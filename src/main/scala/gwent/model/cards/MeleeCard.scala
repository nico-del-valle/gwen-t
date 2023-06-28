package cl.uchile.dcc
package gwent.model.cards

/** A class representing a Combat Melee Card
 *
 * @param name The name of the card
 * @param damage The damage value of the card
 * @constructor Creates a Combat Card with a name, a specific damage, with a combatType Melee
 */

class MeleeCard (name: String,description: String, damage: Int) extends AbstractCombatCard(name, description, damage) {
  val Cardtype = "Melee"
}
