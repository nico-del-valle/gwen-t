package cl.uchile.dcc
package gwent

/** Class that represent the Card Deck
 * 
 * @param cards The Sequence that contains the cards of the Deck
 *              
 * @constructor Creates a Card Deck with a Sequence of Cards
 *              
 * @example
 * {{{
 * val Deck1 = new Deck(Seq(Card1,Card2,Card3)
 * val Deck1 = Deck1.draw(2)
 * Deck1 = Seq(Card3)
 * }}}
 */

private class Deck (var cards: Seq[Card] = Seq.empty) {
  def shuffle(): Unit = {
    cards = util.Random.shuffle(cards)
  }

  /** Drawing cards from the Deck
   * 
   * @param numCards
   * @return The Seq of card without the first (numCards) cards
   *         
   * @example
   * {{{
   * val Deck1 = new Deck(Seq(Card1,Card2,Card3)
   * val Deck1 = Deck1.draw(2)
   * Deck1 = Seq(Card3)
   * }}}        
   */
  
  def draw(numCards: Int): Seq[Card] = {
    val drawnCards = cards.take(numCards)
    cards = cards.drop(numCards)
    drawnCards
  }

}
