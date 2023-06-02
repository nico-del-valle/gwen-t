package cl.uchile.dcc
package gwent.player

import gwent.cards.Card

/** A class representing a Player with name, card hand and card deck
 * 
 * @param name Name of the card
 * @param hand The hand of cards that the player has
 * @param deck The deck of cards where the Player can draw to his hand
 * 
 */
class Player(val name: String, private var _hand: List[Card],
             private var _deck: List[Card]) {


  // deck setter
  def deck: List[Card] = _deck
  // hand setter
  def hand: List[Card] = _hand
  // hand setter
  var gems: Int = 3


  /**
   *
   */
  def lose(): Unit = {
    gems = (gems - 1).max(0)
  }


  /** Draw a card
   *
   * The cards is drawn from the deck and the hand receives it
   *
   * @return the hand and deck after the draw
   */
  def drawCard(): Card = {
    val card = deck.head
    _deck = deck.tail
    _hand = card :: hand
    card
  }


  /** shuffles the Deck
   *
   * randomize the deck
   *
   * @return the deck randomized
   */
  def shuffleDeck(): Unit = {
    _deck = scala.util.Random.shuffle(_deck)
  }

  override def equals(obj: Any): Boolean = {
        if(obj.isInstanceOf[Player]) {
          // We check if the object class are the same
          
          val other = obj.asInstanceOf[Player]
          // We verify if the object are equal by reference
          (this eq other) ||
            // We verify if the objects attributes and values are equal (name)
            (this.name == other.name)
        } else {
          false
        }
  }
   
}
