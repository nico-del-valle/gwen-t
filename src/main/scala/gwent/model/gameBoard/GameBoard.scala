package cl.uchile.dcc
package gwent.model.gameBoard

import gwent.model.cards.*

import cl.uchile.dcc.gwent.model.cards.{Card, MeleeCard, RangedCard, SiegeCard, WeatherCard}

/**
 * @param _meleeBoardP1 Player 1 MeleeCard zone
 * @param _rangedBoardP1 Player 1 RangedCard zone
 * @param _siegeBoardP1 Player 1 SiegeCard zone
 * @param _meleeBoardP2 Player 2 MeleeCard zone
 * @param _rangedBoardP2 Player 2 RangedCard zone
 * @param _siegeBoardP2 Player 2 SiegeCard zone
 * @param _WeatherBoard WheatherCard zone, for both player
 * @constructor creates the game board with all zones (7 zones, 3 each player and 1 for Weather)
 *
 */


class GameBoard {
  // Player 1 board
  private var _meleeBoardP1: List[MeleeCard] = List()
  private var _rangedBoardP1: List[RangedCard] = List()
  private var _siegeBoardP1: List[SiegeCard] = List()

  // Player 2 board
  private var _meleeBoardP2: List[MeleeCard] = List()
  private var _rangedBoardP2: List[RangedCard] = List()
  private var _siegeBoardP2: List[SiegeCard] = List()
  private var _WeatherBoard: List[WeatherCard] = List()

  var meleeDamageP1: Int = 0
  var rangedDamageP1: Int = 0
  var siegeDamageP1: Int = 0
  var P1Damage: Int = 0


  var meleeDamageP2: Int = 0
  var rangedDamageP2: Int = 0
  var siegeDamageP2: Int = 0
  var P2Damage: Int = 0


  /** _meleeBoardP1 getter
   *
   * @return List of Cards on Player 1 MeleeCard zone
   *
   */

  def meleeBoardP1: List[MeleeCard] = _meleeBoardP1

  /** _meleeBoardP1 setter
   *
   * sets the variable of the Player 1 MeleeCard zone
   *
   * @return Updated Card List of Player 1 MeleeCard zone
   */

  def meleeBoardP1_=(newBoard: List[MeleeCard]): Unit = {
    _meleeBoardP1 = newBoard
  }

  /** _rangedBoardP1 getter
   *
   * @return List of Cards on Player 1 RangedCard zone
   *
   */

  def rangedBoardP1: List[RangedCard] = _rangedBoardP1

  /** _rangedBoardP2 setter
   *
   *  set the variable of the Player 1 RangedCard zone
   *
   * @return Updated Card List of Player 1 RangedCard zone
   *
   */

  def rangedBoardP1_=(newBoard: List[RangedCard]): Unit = {
    _rangedBoardP1 = newBoard
  }

  /** _siegeBoardP1 getter
   *
   * @return List of Cards on Player 1 SiegeCard zone
   *
   */

  def siegeBoardP1: List[SiegeCard] = _siegeBoardP1

  /** _siegeBoardP1 setter
   *
   *  set the variable of the Player 1 SiegeCard zone
   *
   * @return Updated Card List of Player 1 SiegeCard zone
   *
   */

  def siegeBoardP1_=(newBoard: List[SiegeCard]): Unit = {
    _siegeBoardP1 = newBoard
  }


  /** _meleeBoardP2 getter
   *
   * @return List of Cards on Player 2 MeleeCard zone
   *
   */

  def meleeBoardP2: List[MeleeCard] = _meleeBoardP2

  /** meleeBoardP2 setter
   *
   * set the variable of the Player 2 MeleeCard zone
   *
   * @return Updated Card List of the Player 2 MeleeCard zone
   *
   */


  def meleeBoardP2_=(newBoard: List[MeleeCard]): Unit = {
    _meleeBoardP2 = newBoard
  }

  /** rangedBoardP2 getter
   *
   * @return List of Cards on Player 2 RangedCard zone
   *
   */

  def rangedBoardP2: List[RangedCard] = _rangedBoardP2

  /** rangedBoardP2 setter
   *
   * set the variable of the Player 2 RangedCard zone
   *
   * @return Updated Card List of the Player 2 RangedCard zone
   *
   */

  def rangedBoardP2_=(newBoard: List[RangedCard]): Unit = {
    _rangedBoardP2 = newBoard
  }

  /** siegeBoardP2 getter
   *
   * set the variable of the Player 2 SiegeCard zone
   *
   * @return Updated Card List of Player 2 SiegeCard zone
   *
   */

  def siegeBoardP2: List[SiegeCard] = _siegeBoardP2

  /** siegeBoardP2 setter
   *
   * set the variable of the Player 2 SiegeCard zone
   *
   * @return Updated Card List of the Player 2 SiegeCard zone
   *
   */

  def siegeBoardP2_=(newBoard: List[SiegeCard]): Unit = {
    _siegeBoardP2 = newBoard
  }

  /** _WeatherBoard getter
   *
   * @return List of Cards on the WeatherCard zone
   *
   */

  def weatherBoard: List[WeatherCard] = _WeatherBoard

  /** _WeatherBoard setter
   *
   *  set the variable of the WeatherCard zone
   *
   * @return Updated Card List of the WeatherCard zone
   *
   */

  def weatherBoard_=(newBoard: List[WeatherCard]): Unit = {
    _WeatherBoard = newBoard
  }



  /** Add a Card to Player 1 board
   *
   * @param card The card we want add to the board
   *
   * @return The board after adding the card
   */

  def addCardPlayer1(card: Card): Unit = {
    if (card.isInstanceOf[MeleeCard]) {
      meleeBoardP1 = card.asInstanceOf[MeleeCard] :: meleeBoardP1
    } else if (card.isInstanceOf[RangedCard]) {
      rangedBoardP1 = card.asInstanceOf[RangedCard] :: rangedBoardP1
    } else if (card.isInstanceOf[SiegeCard]) {
      siegeBoardP1 = card.asInstanceOf[SiegeCard] :: siegeBoardP1
    } else if (card.isInstanceOf[WeatherCard]) {
      weatherBoard = List(card.asInstanceOf[WeatherCard])
    }
  }

  /** Add a Card to Player 2 board
   *
   * @param card The card we want add to the board
   *
   * @return The board after adding the card
   */
  def addCardPlayer2(card: Card): Unit = {
    if (card.isInstanceOf[MeleeCard]) {
      meleeBoardP2 = card.asInstanceOf[MeleeCard] :: meleeBoardP2
    } else if (card.isInstanceOf[RangedCard]) {
      rangedBoardP2 = card.asInstanceOf[RangedCard] :: rangedBoardP2
    } else if (card.isInstanceOf[SiegeCard]) {
      siegeBoardP2 = card.asInstanceOf[SiegeCard] :: siegeBoardP2
    } else if (card.isInstanceOf[WeatherCard]) {
      weatherBoard = List(card.asInstanceOf[WeatherCard])
    }
  }

  /** Removes a Card from Player 1 board
   *
   * @param card The card we want to remove
   * @return The board after removing the card
   */

  def removeCardPlayer1(card: Card): Unit = {
    if (card.Cardtype == "Melee") {
      meleeBoardP1 = meleeBoardP1.filterNot(_ == card)
    } else if (card.Cardtype == "Ranged") {
      rangedBoardP1 = rangedBoardP1.filterNot(_ == card)
    } else if (card.Cardtype == "Siege") {
      siegeBoardP1 = siegeBoardP1.filterNot(_ == card)
    } else if (card.Cardtype == "Weather") {
      weatherBoard = weatherBoard.filterNot(_ == card)
    }
  }

  /** Removes a Card from Player 2 board
   *
   * @param card The card we want to remove
   *
   * @return The board after removing the card
   */

  def removeCardPlayer2(card: Card): Unit = {
    if (card.Cardtype == "Melee") {
      meleeBoardP2 = meleeBoardP2.filterNot(_ == card)
    } else if (card.Cardtype == "Ranged") {
      rangedBoardP2 = rangedBoardP2.filterNot(_ == card)
    } else if (card.Cardtype == "Siege") {
      siegeBoardP2 = siegeBoardP2.filterNot(_ == card)
    } else if (card.Cardtype == "Weather") {
      weatherBoard = weatherBoard.filterNot(_ == card)
    }
  }


  /** Clears all the board
   *
   * @return each board cleared
   */
  def clearBoard(): Unit = {
    meleeBoardP1 = List()
    rangedBoardP1 = List()
    siegeBoardP1 = List()

    meleeBoardP2 = List()
    rangedBoardP2 = List()
    siegeBoardP2 = List()

  }

  def EscarchaEffect(): Unit = {
    val meleeCards = meleeBoardP1 ::: meleeBoardP2
    for (card <- meleeCards) {
      card.currentPower = 1
    }
  }
  def NieblaEffect(): Unit = {
    val rangedCards = rangedBoardP1 ::: rangedBoardP2
    for (card <- rangedCards) {
     card.currentPower = 1
    }
  }

  def LluviaEffect(): Unit = {
    val siegeCards = siegeBoardP1 ::: siegeBoardP2
    for (card <- siegeCards) {
      card.currentPower = 1
    }
  }


  def ApplyWeather(): Unit = {
    if (weatherBoard.exists(_.name == "Escarcha Mordiente")) {
      EscarchaEffect()
    } else if (weatherBoard.exists(_.name == "Niebla Impenetrable")) {
      NieblaEffect()
    } else if (weatherBoard.exists(_.name == "Lluvia Torrencial")) {
      LluviaEffect()
    } else {

    }
  }



  def calculateDamageP1(): Unit  = {

    for (card <- meleeBoardP1) {
      meleeDamageP1 +=  card.currentPower
    }

    for (card <- rangedBoardP1) {
      rangedDamageP1 += card.currentPower
    }


    for (card <- siegeBoardP1){
      siegeDamageP1 += card.currentPower
    }

    P1Damage = meleeDamageP1 + rangedDamageP1 + siegeDamageP1

  }

  def calculateDamageP2(): Unit = {



    for (card <- meleeBoardP2) {
      meleeDamageP2 += card.currentPower
    }

      for (card <- rangedBoardP2) {
      rangedDamageP2 += card.currentPower
    }


      for (card <- siegeBoardP2) {
      siegeDamageP2 += card.currentPower
    }

    P2Damage = meleeDamageP2 + rangedDamageP2 + siegeDamageP2

  }

}
