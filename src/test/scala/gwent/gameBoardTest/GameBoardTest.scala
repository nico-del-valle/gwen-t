package cl.uchile.dcc
package gwent.gameBoardTest

import gwent.cards.{MeleeCard, RangedCard, SiegeCard, WeatherCard}
import gwent.gameBoard.GameBoard

import munit.FunSuite

class GameBoardTest extends FunSuite {
  val name1: String = "Geralt"
  val name2: String = "Ciri"
  val damage1: Int = 1
  val damage2: Int = 2
  val description: String = "a"


  var meleeCard: MeleeCard = _
  var rangedCard: RangedCard = _
  var siegeCard: SiegeCard = _
  var weatherCard: WeatherCard = _
  var board: GameBoard = _


  override def beforeEach(context: BeforeEach): Unit = {
    meleeCard = new MeleeCard(name1, description, damage1)
    rangedCard = new RangedCard(name2, description, damage2)
    siegeCard = new SiegeCard(name1, description, damage2)
    weatherCard = new WeatherCard(name1, description)
    board = new GameBoard()
  }


  test("you can add a card to the board and it goes to its specific place "){
    board.addCardPlayer1(meleeCard)
    board.addCardPlayer1(rangedCard)
    board.addCardPlayer1(siegeCard)

    board.addCardPlayer2(meleeCard)
    board.addCardPlayer2(rangedCard)
    board.addCardPlayer2(siegeCard)

    board.addCardPlayer1(weatherCard)
    board.addCardPlayer2(weatherCard)

    assertEquals(board.meleeBoardP1, List(meleeCard))
    assertEquals(board.rangedBoardP1, List(rangedCard))
    assertEquals(board.siegeBoardP1, List(siegeCard))
    assertEquals(board.meleeBoardP2, List(meleeCard))
    assertEquals(board.rangedBoardP2, List(rangedCard))
    assertEquals(board.siegeBoardP2, List(siegeCard))
    assertEquals(board.weatherBoard, List(weatherCard))
  }

  test("you can remove cards from the board"){
    board.addCardPlayer1(meleeCard)
    board.addCardPlayer1(rangedCard)
    board.addCardPlayer1(siegeCard)

    board.addCardPlayer2(meleeCard)
    board.addCardPlayer2(rangedCard)
    board.addCardPlayer2(siegeCard)

    board.addCardPlayer1(weatherCard)
    board.addCardPlayer2(weatherCard)


    board.removeCardPlayer1(meleeCard)
    board.removeCardPlayer1(rangedCard)
    board.removeCardPlayer1(siegeCard)

    board.removeCardPlayer2(meleeCard)
    board.removeCardPlayer2(rangedCard)
    board.removeCardPlayer2(siegeCard)

    board.removeCardPlayer1(weatherCard)
    board.removeCardPlayer2(weatherCard)

    assertEquals(board.meleeBoardP1, List())
    assertEquals(board.rangedBoardP1, List())
    assertEquals(board.siegeBoardP1, List())

    assertEquals(board.meleeBoardP2, List())
    assertEquals(board.rangedBoardP2, List())
    assertEquals(board.siegeBoardP2, List())

    assertEquals(board.weatherBoard, List())
  }


  test("you can clear the deck") {

    board.addCardPlayer1(meleeCard)
    board.addCardPlayer2(siegeCard)
    board.addCardPlayer1(rangedCard)

    board.clearBoard()

    assertEquals(board.meleeBoardP1, List())
    assertEquals(board.rangedBoardP1, List())
    assertEquals(board.siegeBoardP1, List())
    assertEquals(board.meleeBoardP2, List())
    assertEquals(board.rangedBoardP2, List())
    assertEquals(board.siegeBoardP2, List())

  }
}
