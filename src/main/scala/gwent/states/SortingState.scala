package cl.uchile.dcc
package gwent.states

import gwent.GameController
import gwent.model.player.Player

class SortingState(context: GameController) extends GameState(context) {

  override def toSelectingActionState(): Unit = {
    context.state = new SelectingActionState(context)
  }


  override def doAction(Player_1: Player, Player_2: Player): Unit = {
    context.doSort(Player_1, Player_2)
  }


}
