package cl.uchile.dcc
package gwent.model.gameBoard

import gwent.model.cards.MeleeCard

class MeleeBoard {
  private var _cards: List[MeleeCard] = List()
  
  def cards: List[MeleeCard] = _cards
  
  
  def addCard(card: MeleeCard): Unit = {
    _cards = card :: _cards
  }
  
  def removeCard(card: MeleeCard): Unit = {
    _cards = _cards.filterNot(_ == card)
  }

  def clearBoard(): Unit = {
    _cards = List()
  }
}
  
