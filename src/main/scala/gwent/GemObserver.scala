package cl.uchile.dcc
package gwent

import cl.uchile.dcc.gwent.model.player.Player

trait GemObserver {
  def gemsDepleted(loser: Player): Unit
}
