package cl.uchile.dcc
package gwent.states

import gwent.GameController

class CalculatingRoundWinnerState (context: GameController) extends GameState(context) {



  override def toRestartingRoundState(): Unit = {
    context.state = new RestartingRoundState(context)
  }

  // remember to make another state, the final state

}
