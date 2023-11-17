package cl.uchile.dcc
package gwent.model.cards

import gwent.model.player.Player

/**  A class representing a Combat Siege Card
 *
 * @param name The name of the card
 * @param damage The damage value of the card
 * @constructor Creates a Combat Card with a name, a specific damage, with a combatType Siege
 */
class SiegeCard (name: String, description: String, damage: Int) extends AbstractCombatCard(name, description, damage) {


  override def addCard(player: Player): Unit = {
    player.siegeBoard.addCard(this)
    player.removeCardFromHand(this)
    }
  

  override def removeCard(player: Player): Unit = {
    player.siegeBoard.removeCard(this)
    }
  


}
