package cl.uchile.dcc
package gwent

import gwent.Card

/** Class than represents the hand player
 * 
 * @param cards The cards that you have in your hand and you can use
 */

private class Hand (var cards: List[Card] = List()) {

  /** Adds cards to the hand
   * 
   * @param card The card we want to add to the hand
   * @return List of cards the Player has in his hand
   *  
   * @example
   * {{{
   * val Hand1 = new Hand(List(Card1, Card2))
   * Hand1.add(Card3)
   * Hand1.cards (in this case is List(Card1,Card2,Card3))
   * }}} 
   */
  def add(card: Card): Unit = {
    cards = card :: cards
  }

  /** Removes cards from the hand
   * 
   * @param card The card we want to remove from the hand (when you use a card you need to remove it from the hand)
   * @return List of cards the player has in his hand
   *         
   * @example
   * {{{
   * val Hand1 = new Hand(List(Card1, Card2))
   * Hand1.remove(Card2)
   * Hand1.cards (in this case is List(Card1))
   * }}}
   */
  def remove(card: Card): Unit = {
    cards = cards.filterNot(_ == card)
  }

}
 





