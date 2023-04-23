package cl.uchile.dcc
package gwent


/** Class of a Climate Cards with a given name
 * 
 * @param name The card name
 * 
 * @constructor Creates a Climate Card with the specified name
 *
 */
private class ClimateCard (val name: String) extends Card {

  /** The type of the cards
   *
   * Describes where it can be placed
   */

  val tipo = "Climate"

  /**
   * 
   * @param obj recieve 2 object and co
   * @return
   */

  override def equals(obj: Any): Boolean = {
    obj match {
      case card: ClimateCard => card.name == this.name && card.tipo == this.tipo
      case _ => false
    }
  }
}





