package cl.uchile.dcc
package gwent
import scala.util.Random


/** A class representing a Player
 *
 * A player is defines by its name, his gems (life), the cards in his hands, and the card in the deck
 *
 * @param name Name of the Player
 * @param gem Is the Player "Health Points"
 * @param cardDeck Is the deck that contains the 25 cards
 * @param cardHand Is the cards that you can draw from your cardDeck and can use in the Table
 */


// Also I can try to make a class for cardDeck and handDeck, instead of doing only one big class
class Player(val name: String, var gem: Int, var cardDeck: Array[Object], var cardHand:Array[Object]) {

  def shuffleDeck(): Unit = {
    cardDeck = Random.shuffle(cardDeck.toSeq).toArray

  }
  def lose(): Unit = {
    if (gem <= 0) // you already lose
      gem = 0
    else
      gem -= 1  // if you are alive and lose a round, your gem is reduced by 1
    }

  //def initialDraw(): Unit // we draw the initial 10 cards


  def draw3(): Array[Object] = { // we draw 3 cards from the deck ,
    shuffleDeck()

    val cardsDrawn = cardDeck.toSeq.take(3)
    cardDeck = cardDeck.drop(3)
    cardHand = cardHand ++ cardsDrawn
    cardsDrawn.toArray

  }
}


