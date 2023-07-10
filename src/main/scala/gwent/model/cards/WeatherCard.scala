package cl.uchile.dcc
package gwent.model.cards

import gwent.model.gameBoard.WeatherBoard
import gwent.model.player.Player

/** Class of a Climate Cards with a given name
 * 
 * @param name The card name
 * @constructor Creates a Climate Card with the specified name
 *
 */
class WeatherCard(val name: String, val description: String) extends Card {

  

  override def addCard(player: Player): Unit = {
    player.playWeatherCard(this)
  }

  override def removeCard(player: Player): Unit = {
   WeatherBoard.removeCard()
  }













  /**
   * 
   * @param obj recieve 2 object and co
   * @return true if 
   */


  override def equals(obj: Any): Boolean = {
    if (obj.isInstanceOf[WeatherCard]) {
      // We check if the objects class are the same

      val other = obj.asInstanceOf[WeatherCard]
      //  We verify if the object are equal by reference.
      (this eq other) ||
        // 3. We verify if the objects attributes and values are equal (name and description)
        (this.name == other.name && this.description == other.description)
    } else {
      false
    }
  }

}





