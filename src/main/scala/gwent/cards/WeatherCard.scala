package cl.uchile.dcc
package gwent.cards

/** Class of a Climate Cards with a given name
 * 
 * @param name The card name
 * @constructor Creates a Climate Card with the specified name
 *
 */
class WeatherCard(val name: String, val description: String) extends Card {

  /** The type of the cards
   *
   * Describes where it can be placed
   */

  val Cardtype = "Weather"

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





