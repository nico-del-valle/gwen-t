package cl.uchile.dcc
package gwent


/** Class of a Climate Cards with a given name
 * 
 * @param name The card name
 * 
 * @constructor Creates a Climate Card with the specified name
 *
 */
private class WeatherCard(val name: String, val description: String) extends Card {

  /** The type of the cards
   *
   * Describes where it can be placed
   */

  val Cardtype = "Weather"

  /**
   * 
   * @param obj recieve 2 object and co
   * @return
   */

  override def equals(obj: Any): Boolean = {
    obj match {
      case card: WeatherCard => card.name == this.name && card.Cardtype == this.Cardtype
        && card.description == this.description
      case _ => false
    }
  }
}





