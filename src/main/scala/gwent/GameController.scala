package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.model.player.Player
import cl.uchile.dcc.gwent.states.*
import cl.uchile.dcc.gwent.view.UserInterface



class GameController(val userInterface: UserInterface) {

  var state: GameState = new StartingGameState(this)

  //starting game
  //We need the 2 player, with his deck, hand
  //We need the initial Game board

  def startGame(
                 Player_1: Player,
                 Player_2: Player
               ): Unit = {
    var state = new StartingGameState(this)
  }

  //i think i need to implement the transition between start to sort, in startgame method
  // or maybe sort in the start of the game

  def SortStart(): Unit = {
    val who = scala.util.Random.nextInt(2) + 1
    println(s"The Player$who starts")
    if (who == 1) state.toSelectingActionP1State()
    else state.toSelectingActionP2State()
  }

  //prompt to choose players actions

  def promptAction(): Unit = {
    println("Escoge la accion que quieres realizas: Usar Cartas , Pasar Turno ")
  }

  def promptCard(): Unit = {
    println("Escoge la carta que quieras jugar")
  }


  /**def ActionP1(): Unit = {
    val action1: String = userInterface.promptSelection(List("Usar Carta", "Pasar Turno"))
    if (action1 == "Usar Carta") state.toSelectingCardP1State()
    else if (action1 == "Pasar Turno") state.toSelectingActionP2State()
    else {
      println("Accion Invalida, Intente nuevamente")
      ActionP1()
    }
  }
  def ActionP2(): Unit = {
    val action2 = userInterface.promptSelection(List("Usar Carta", "Pasar Turno"))
    if (action2 == "Usar Carta") state.toSelectingCardP2State()
    else if (action2 == "Pasar Turno") state.toSelectingActionP1State()
    else {
      println("Accion Invalida, Intente nuevamente")
      ActionP1()
    }
   }

  def UseCardP1(): Unit = {
    val use = userInterface.promptSelection(List("Carta A", "Carta B", "Carta"))
    if (!List("Carta A", "Carta B", "Carta").contains(use)) {
      println("Accion Invalida, Intente nuevamente")
      UseCardP1()
    }
    else state.toSelectingActionP2State()

  }

  def UseCardP2(): Unit = state.toSelectingCardP2State() */








}
