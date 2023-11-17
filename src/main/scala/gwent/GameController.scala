package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.model.cards.{Card, MeleeCard, RangedCard, SiegeCard, WeatherCard}
import cl.uchile.dcc.gwent.model.player.Player
import cl.uchile.dcc.gwent.states.*
import cl.uchile.dcc.gwent.view.UserInterface
import cl.uchile.dcc.gwent.view.ConsoleUI



class GameController (val userInterface: UserInterface) extends GemObserver {


  private var ActionList: List[String] = List("Usar Carta", "Pasar")
  var SelectionCard: Option[Card] = None
  var SelectionAction: Option[String] = None
  var currentCharacter: Option[Player] = None
  var skipedTurnsP1: Int = 0 // if the player skips once, he cant do nothing more
  var skipedTurnsP2: Int = 0 // if the player skips once, he cant do nothing more
  var totalSkips: Int = 0  // if both skip, we calculate the round winner
  var loser: Option[Player] = None
  var winner: Option[Player] = None


  // Inicializamos el juego

  var state: GameState = new StartingGameState(this)

  override def gemsDepleted(loser: Player): Unit = {
    println(s"${loser.name} ha perdido todas sus gemas, el juego ha terminado. :(")


  }


  def startGame(Player_1: Player, Player_2: Player): Unit = {
    state = new StartingGameState(this)
    Player_1.addGemObserver(this)
    Player_2.addGemObserver(this)
    state.toSortingWhoStartState()

  }

  // Sorteamos quien parte

  def doSort(Player_1: Player, Player_2: Player): Unit = {
    val who = scala.util.Random.nextInt(2) + 1
    println(s"El Jugador $who comienza")
    currentCharacter = Some(if (who == 1) Player_1 else Player_2)
    state.toSelectingActionState()
  }




  def promptAction(Player_1: Player, Player_2: Player): Unit = {
    println("Escoge la accion que quieres realizas: Usar Carta o Pasar Turno ")
    val input = userInterface.promptSelection(ActionList)
    SelectionAction = Some(ActionList(input))

    currentCharacter match {
      case Some(Player_1) =>

        if (SelectionAction.contains("Usar Carta")) {
          state.toSelectingCardState()
        } else if (SelectionAction.contains("Pasar Turno")) {
          currentCharacter = Some(Player_2)
          state.toSelectingActionState()
        }
      case Some(Player_2) =>
        if (SelectionAction.contains("Usar Carta")) {
          state.toSelectingCardState()
        } else if (SelectionAction.contains("Pasar Turno")) {
          currentCharacter = Some(Player_1)
          state.toSelectingActionState()
        }
    }
  }



  def promptCard(Player_1: Player, Player_2: Player): Unit = {
    println("Escoge la carta que quieras jugar")
    currentCharacter match {
      case Some(Player_1) =>
        val input = userInterface.promptSelection(Player_1.hand.map(_.name))
        SelectionCard = Some(Player_1.hand(input))
      case Some(Player_2) =>
        val input = userInterface.promptSelection(Player_2.hand.map(_.name))
        SelectionCard = Some(Player_2.hand(input))
    }
  }

  def restart(Player_1: Player, Player_2: Player): Unit = {
    Player_1.calculateDamage()
    Player_2.calculateDamage()
  }

  def Roundwinner(Player_1: Player, Player_2: Player): Unit = {
    val damagePlayer1 = Player_1.calculateDamage()
    val damagePlayer2 = Player_2.calculateDamage()

    if (damagePlayer1 > damagePlayer2) {
      val Ganador = Player_1
      println(s"El Ganador de esta ronda es: $Player_1" )
      Player_2.lose()
      currentCharacter = Some(Player_2) // the player that loses start next round
    } else if (damagePlayer2 > damagePlayer1) {
      println(s"El Ganador de esta ronda es $Player_2")
      Player_1.lose()
      currentCharacter = Some(Player_1)
    } else {
      println(s"Empataron!!")
      println("Ninguno pierde vida :D")
    }
  }


  def endGame(Player_1: Player, Player_2: Player): Unit = {

    println(s" Gano el Juego")

  }













}
