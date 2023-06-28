package cl.uchile.dcc
package gwent.states

import gwent.GameController

class SelectingActionP1State (context: GameController) extends GameState(context) {

  override def toSelectingCardP1State(): Unit = {
    context.state = new SelectingCardP1State(context)
  }

  
  // Skip the turn, and the other player plays
  override def toSelectingActionP2State(): Unit = {
    context.state = new SelectingActionP2State(context)
  }
  
  override def toCalculatingRoundWinnerState():Unit = {
    context.state = new CalculatingRoundWinnerState(context)
  }

}
