package cl.uchile.dcc
package gwent

/** A class representing a Player with name, card hand and card deck
 * 
 * @param name Name of the card
 * @param hand The hand of cards that the player has
 * @param deck The deck of cards where the Player can draw to his hand
 * 
 */
class Player(val name: String, private var _hand: List[Card],
                     var _deck: List[Card]) {

  def deck: List[Card] = _deck

  def hand: List[Card] = _hand

  var gems: Int = 3

  def lose(): Unit = {
    gems = (gems - 1).max(0)
  }




  def drawCard(): Card = {
    val card = deck.head
    _deck = deck.tail
    _hand = card :: hand
    card
  }



  def shuffleDeck(): Unit = {
    _deck = scala.util.Random.shuffle(_deck)
  }

  override def equals(other: Any): Boolean = other match {
    case player: Player => this.name == player.name
    case _ => false
  }

}
