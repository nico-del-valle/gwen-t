package cl.uchile.dcc
package gwent.states

import gwent.GameController

class SortingWhoStartState(context: GameController) extends GameState(context) {

  override def toSelectingActionP1State(): Unit = {
    context.state = new SelectingCardP1State(context)
  }

  override def toSelectingActionP2State(): Unit = {
    context.state = new SelectingCardP2State(context)
  }

}
