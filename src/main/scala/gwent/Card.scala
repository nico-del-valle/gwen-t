package cl.uchile.dcc
package gwent


/** A class representing a Gwent Card
 *
 * A card is defined by its name, Class, Category and Damage
 *
 * @param name The card name
 * @param cardClass The type of the card (Unit or Climate)
 * @param cardCategory The category of the card (Close combat, Ranged Combat, Siege)
 * @param damage The damage value of each card
 */

class Card (val name: String, val cardClass: String, val cardCategory: String, var damage: Int ) {
  def AtkLose(x: Int ): Unit = { // The card lose x damage
    if (damage <= x)  // if the damage resultant is equal or less than 0, return 0, we can't have negative damage
      damage = 0
    else
      damage -= x    // else we subtract x from the card damage
  }

  def AtkGain(x: Int): Unit = { // The card gain x damage
    damage += x   //we add x to the card damage
  }
}
