package cl.uchile.dcc
package gwent.states

import gwent.GameController


class StartingGameState(context: GameController) extends GameState(context){

  override def toSortingWhoStartState(): Unit = {
    context.state = new SortingWhoStartState(context)

  }

}
