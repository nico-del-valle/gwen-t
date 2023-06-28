package cl.uchile.dcc
package gwent.states

import gwent.GameController

class SelectingActionP2State (context: GameController) extends GameState(context){
  
  override def toSelectingCardP2State(): Unit = {
    context.state = new SelectingCardP2State(context)
  }


  // Skip the turn, and the other player plays
  override def toSelectingActionP1State(): Unit = {
    context.state = new SelectingActionP1State(context)
  }

  override def toCalculatingRoundWinnerState(): Unit = {
    context.state = new CalculatingRoundWinnerState(context)
  }


}
