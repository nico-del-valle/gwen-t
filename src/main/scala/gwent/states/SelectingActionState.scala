package cl.uchile.dcc
package gwent.states

import gwent.GameController
import gwent.model.player.Player

class SelectingActionState(context: GameController) extends GameState(context) {

  override def toSelectingCardState(): Unit = {
    context.state = new SelectingCardState(context)
  }

  
  override def toCalculatingRoundWinnerState():Unit = {
    context.state = new CalculatingRoundWinnerState(context)
  }

  override def doAction(Player_1: Player, Player_2: Player): Unit = {
    context.promptAction(Player_1, Player_2)
  }

}
