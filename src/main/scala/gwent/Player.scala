package cl.uchile.dcc
package gwent

import gwent.Hand

/** A class representing a Player with name, card hand and card deck
 * 
 * @param name Name of the card
 * @param hand The hand of cards that the player has
 * @param deck The deck of cards where the Player can draw to his hand
 * 
 */
private class Player(val name: String, var hand: Hand = new Hand(List.empty[Card]), var deck: Seq[Card] = Seq.empty) {
  var gems: Int = 3

  def lose(): Unit = {
    gems = (gems - 1).max(0)
  }

  override def equals(other: Any): Boolean = other match {
    case player: Player => this.name == player.name
    case _ => false
  }

}
