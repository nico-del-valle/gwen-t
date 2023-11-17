package cl.uchile.dcc
package gwent.model.gameBoard

import cl.uchile.dcc.gwent.model.cards.{Card, WeatherCard}

object WeatherBoard {
  private var _cards: Option[WeatherCard] = None

  def cards: Option[WeatherCard] = _cards


  def addCard(card: WeatherCard): Unit = {
    _cards  = Some(card)
  }

  def removeCard(): Unit = {
    _cards = None
  }



}
