package cl.uchile.dcc
package gwent.states

import gwent.GameController
import gwent.model.player.Player

class CalculatingRoundWinnerState (context: GameController) extends GameState(context) {



  override def toRestartingRoundState(): Unit = {
    context.state = new RestartingRoundState(context)
  }



  override def doAction(Player_1: Player, Player_2: Player): Unit = {
    context.Roundwinner(Player_1, Player_2)
  }



}
