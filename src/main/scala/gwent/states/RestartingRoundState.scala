package cl.uchile.dcc
package gwent.states

import gwent.GameController

class RestartingRoundState (context: GameController) extends GameState(context) {

  override def toSelectingActionP1State(): Unit = {
    context.state = new SelectingActionP1State(context)

  }

  override def toSelectingActionP2State(): Unit = {
    context.state = new SelectingActionP2State(context)
  }



}
