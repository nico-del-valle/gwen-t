package cl.uchile.dcc
package gwent.model.player

import cl.uchile.dcc.gwent.model.cards.{Card, MeleeCard, RangedCard, SiegeCard, WeatherCard}
import cl.uchile.dcc.gwent.model.gameBoard.{MeleeBoard, RangedBoard, SiegeBoard, WeatherBoard}
import gwent.model.player.Player

import cl.uchile.dcc.gwent.GemObserver

import scala.collection.mutable.ListBuffer


/** A class representing a Player with name, card hand and card deck
 * 
 * @param name Name of the card
 * @param hand The hand of cards that the player has
 * @param deck The deck of cards where the Player can draw to his hand
 * 
 */
class Player(val name: String, private var _hand: List[Card],
             private var _deck: List[Card]) {

  private val _meleeBoard: MeleeBoard = new MeleeBoard
  private val _rangedBoard: RangedBoard = new RangedBoard
  private val _siegeBoard: SiegeBoard = new SiegeBoard
  private var gemObservers: List[GemObserver] = List()

  // deck setter
  def deck: List[Card] = _deck
  // hand setter
  def hand: List[Card] = _hand
  // hand setter
  var gems: Int = 2
  def meleeBoard: MeleeBoard = _meleeBoard
  def rangedBoard: RangedBoard = _rangedBoard
  def siegeBoard: SiegeBoard = _siegeBoard




  def addGemObserver(observer: GemObserver): Unit = {
    gemObservers = observer :: gemObservers
  }

  def removeGemObserver(observer: GemObserver): Unit = {
    gemObservers = gemObservers.filterNot(_ == observer)
  }

  private def notifyGemDepleted(loser: Player): Unit = {
    gemObservers.foreach(_.gemsDepleted(loser))
  }
  def lose(): Unit = {
    gems = (gems - 1).max(0)
    if (gems == 0) {
      notifyGemDepleted(this)
    }

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
   * */

  def shuffleDeck(): Unit = {
    _deck = scala.util.Random.shuffle(_deck)
  }


  def playWeatherCard(weatherCard: WeatherCard): Unit = {
    WeatherBoard.addCard(weatherCard)
    _hand = _hand.filterNot(_ == weatherCard)
  }


  def applyWeatherEffect(): Unit = {
    WeatherBoard.cards.foreach { weatherCard =>
      weatherCard.name match {
        case "Escarcha Mordiente" =>
          _meleeBoard.cards.foreach(_.currentPower = 1)
        case "Niebla Impenetrable" =>
          _rangedBoard.cards.foreach(_.currentPower = 1)
        case "Lluvia Torrencial" =>
          _siegeBoard.cards.foreach(_.currentPower = 1)
        case _ =>
      }
    }
  }

  def removeCardFromHand(card: Card): Unit = {
    _hand = _hand.filterNot((_ == card))
  }



  def calculateDamage(): Int = {
    applyWeatherEffect()
    val meleeDamage = _meleeBoard.cards.map(_.currentPower).sum
    val rangedDamage = _rangedBoard.cards.map(_.currentPower).sum
    val siegeDamage = _siegeBoard.cards.map(_.currentPower).sum
    meleeDamage + rangedDamage + siegeDamage
  }

  def clearPlayerBoard(): Unit = {
    _meleeBoard.clearBoard()
    _rangedBoard.clearBoard()
    _siegeBoard.clearBoard()
    WeatherBoard.removeCard()
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
