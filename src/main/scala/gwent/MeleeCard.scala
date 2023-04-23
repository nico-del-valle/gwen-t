package cl.uchile.dcc
package gwent

import gwent.AbstractCombatCard

/** A class representing a Combat Melee Card
 *
 * @param name The name of the card
 * @param damage The damage value of the card
 *
 * @constructor Creates a Combat Card with a name, a specific damage, with a combatType Melee
 */

private class MeleeCard (val name: String, damage: Int) extends AbstractCombatCard(name,damage,"Melee") {
}
