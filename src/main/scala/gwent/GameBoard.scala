package cl.uchile.dcc
package gwent

class GameBoard {
  // Player 1 board
  var meleeBoardP1: List[MeleeCard] = List()
  var rangedBoardP1: List[RangedCard] = List()
  var siegeBoardP1: List[SiegeCard] = List()

  // Player 2 board
  var meleeBoardP2: List[MeleeCard] = List()
  var rangedBoardP2: List[RangedCard] = List()
  var siegeBoardP2: List[SiegeCard] = List()
  var WeatherBoard: List[WeatherCard] = List()

  def addCardPlayer1(card: Card): Unit = {
    if (card.isInstanceOf[MeleeCard]) {
      meleeBoardP1 = card.asInstanceOf[MeleeCard] :: meleeBoardP1
    } else if (card.isInstanceOf[RangedCard]) {
      rangedBoardP1 = card.asInstanceOf[RangedCard] :: rangedBoardP1
    } else if (card.isInstanceOf[SiegeCard]) {
      siegeBoardP1 = card.asInstanceOf[SiegeCard] :: siegeBoardP1
    } else if (card.isInstanceOf[WeatherCard]) {
      WeatherBoard = List(card.asInstanceOf[WeatherCard])
    }
  }


  def addCardPlayer2(card: Card): Unit = {
    if (card.isInstanceOf[MeleeCard]) {
      meleeBoardP2 = card.asInstanceOf[MeleeCard] :: meleeBoardP2
    } else if (card.isInstanceOf[RangedCard]) {
      rangedBoardP2 = card.asInstanceOf[RangedCard] :: rangedBoardP2
    } else if (card.isInstanceOf[SiegeCard]) {
      siegeBoardP2 = card.asInstanceOf[SiegeCard] :: siegeBoardP2
    } else if (card.isInstanceOf[WeatherCard]) {
      WeatherBoard = List(card.asInstanceOf[WeatherCard])
    }
  }

  def removeCardPlayer1(card: Card): Unit = {
    if (card.Cardtype == "Melee") {
      meleeBoardP1 = meleeBoardP1.filterNot(_ == card)
    } else if (card.Cardtype == "Ranged") {
      rangedBoardP1 = rangedBoardP1.filterNot(_ == card)
    } else if (card.Cardtype == "Siege") {
      siegeBoardP1 = siegeBoardP1.filterNot(_ == card)
    } else if (card.Cardtype == "Weather") {
      WeatherBoard = WeatherBoard.filterNot(_ == card)
    }
  }

  def removeCardPlayer2(card: Card): Unit = {
    if (card.Cardtype == "Melee") {
      meleeBoardP2 = meleeBoardP2.filterNot(_ == card)
    } else if (card.Cardtype == "Ranged") {
      rangedBoardP2 = rangedBoardP2.filterNot(_ == card)
    } else if (card.Cardtype == "Siege") {
      siegeBoardP2 = siegeBoardP2.filterNot(_ == card)
    } else if (card.Cardtype == "Weather") {
      WeatherBoard = WeatherBoard.filterNot(_ == card)
    }
  }



  def clearBoard(): Unit = {
    meleeBoardP1 = List()
    rangedBoardP1 = List()
    siegeBoardP1 = List()

    meleeBoardP2 = List()
    rangedBoardP2 = List()
    siegeBoardP2 = List()

  }
}
