package cl.uchile.dcc
package gwent.states

import gwent.GameController

class SelectingCardP1State (context: GameController) extends GameState(context) {

  override def toSelectingActionP2State(): Unit = {
    context.state = new SelectingActionP2State(context)
  }

}
