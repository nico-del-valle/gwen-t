package cl.uchile.dcc
package gwent.model.gameBoard

import gwent.model.cards.RangedCard

class RangedBoard {
  private var _cards: List[RangedCard] = List()

  def cards: List[RangedCard] = _cards


  def addCard(card: RangedCard): Unit = {
    _cards = card :: _cards
  }

  def removeCard(card: RangedCard): Unit = {
    _cards = _cards.filterNot(_ == card)
  }

  def clearBoard(): Unit = {
    _cards = List()
  }
}
