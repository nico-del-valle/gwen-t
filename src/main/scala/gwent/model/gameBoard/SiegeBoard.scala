package cl.uchile.dcc
package gwent.model.gameBoard

import gwent.model.cards.SiegeCard

class SiegeBoard {

  private var _cards: List[SiegeCard] = List()

  def cards: List[SiegeCard] = _cards


  def addCard(card: SiegeCard): Unit = {
    _cards = card :: _cards
  }

  def removeCard(card: SiegeCard): Unit = {
    _cards = _cards.filterNot(_ == card)
  }
  
  def clearBoard(): Unit = {
    _cards = List()
  }
}
