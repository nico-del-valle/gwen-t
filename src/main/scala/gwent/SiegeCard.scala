package cl.uchile.dcc
package gwent

/**  A class representing a Combat Siege Card
 *
 * @param name The name of the card
 * @param damage The damage value of the card
 *
 * @constructor Creates a Combat Card with a name, a specific damage, with a combatType Siege
 */
private class SiegeCard (val name: String, damage: Int) extends AbstractCombatCard(name,damage,"Siege") {
   val combatType = "Siege"
}
