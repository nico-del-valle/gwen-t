package cl.uchile.dcc
package gwent.states

import gwent.GameController

class SelectingCardP2State (context: GameController) extends GameState(context) {

  override def toSelectingActionP1State(): Unit = {
    context.state = new SelectingActionP1State(context)
  }
}


