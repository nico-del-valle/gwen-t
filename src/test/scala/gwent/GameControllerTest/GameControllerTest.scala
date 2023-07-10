package cl.uchile.dcc
package gwent.GameControllerTest

import cl.uchile.dcc.gwent.model.cards.{MeleeCard, RangedCard, SiegeCard, WeatherCard}
import cl.uchile.dcc.gwent.model.player.Player
import cl.uchile.dcc.gwent.GameController
import cl.uchile.dcc.gwent.states.{SelectingActionState, SortingState, StartingGameState,
SelectingCardState}
import cl.uchile.dcc.gwent.view.{ConsoleUI, UserInterface}
import munit.FunSuite

class GameControllerTest extends FunSuite {

  class MockUserInterface extends UserInterface {
    var promptSelectionCalled = false
    var promptSelectionOptions: List[String] = Nil
    var promptSelectionResult: Option[Int] = None

    def setPromptSelectionResult(result: Int): Unit = {
      promptSelectionResult = Some(result)
    }

    override def promptSelection(options: List[String]): Int = {
      promptSelectionCalled = true
      promptSelectionOptions = options
      promptSelectionResult.getOrElse(0)

    }
  }

  val userInterface = new MockUserInterface()
  val gameController = new GameController(userInterface)


  val name1: String = "Geralt"
  val name2: String = "Eredin"
  var P1: Player = _
  var P2: Player = _


  val Card1 = new MeleeCard("Card1", "a", 1)
  val Card2 = new RangedCard("Card2", "a", 2)
  val Card3 = new SiegeCard("Card3", "a", 3)
  val Card4 = new WeatherCard("Card4", "a")
  val Card5 = new WeatherCard("Card5", "a")

  val Card6 = new MeleeCard("Card6", "a", 1)
  val Card7 = new MeleeCard("Card7", "a", 2)
  val Card8 = new RangedCard("Card8", "a", 3)
  val Card9 = new SiegeCard("Card9", "a", 4)
  val Card10 = new WeatherCard("Card10", "a")

  val Deck1 = List(Card1, Card2, Card3, Card4, Card5)
  val Deck2 = List(Card6, Card7, Card8, Card9, Card10)

  var Hand1 = List(Card1, Card2, Card3)
  var Hand2 = List(Card3, Card4, Card5)

  override def beforeEach(context: BeforeEach): Unit = {
    P1 = new Player(name1, Hand1, Deck1)
    P2 = new Player(name2, Hand2, Deck2)

  }

  test("we can start the game") {
    gameController.startGame(P1, P2)
    assert(gameController.state.isInstanceOf[SortingState]) // after starting it changes to SortingState
  }


  test("The controller can sort who start") {
    // to make this assert, we can define a seed
    val state = new SortingState(gameController)
    state.doAction(P1, P2)

    val currentState = gameController.state

    assert(currentState.isInstanceOf[SelectingActionState])

  }

  test("The Player can choose an Action") {
    val state = new SelectingActionState(gameController)
    state.doAction(P1, P2)
    assert(userInterface.promptSelectionCalled)
    assert(userInterface.promptSelectionOptions == List("Usar Carta", "Pasar"))
    val currenState = gameController.state


    assert(currenState.isInstanceOf[SelectingCardState])
  }

  test("The player can choose a Card") {
    val state = new SelectingCardState(gameController)
    userInterface.setPromptSelectionResult(1)
    state.doAction(P1, P2)
    println(s"P1Hand:")
    assert(userInterface.promptSelectionCalled)
  }


  test("The Player receives a notification when he lost all his life") {

  }

  test("P1 loses all gems") {
    gameController.startGame(P1, P2)

    P1.lose()
    P1.lose()





    /*
  }
  test("The controller can restart the board, to star a new round"){

  }
  test("The controller can end the game and decide the winner"){

  }*/
  }
}


