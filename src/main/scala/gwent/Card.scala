package cl.uchile.dcc
package gwent


/**
 *  A trait representing a generic card
 *  
 *  A generic card if defined by its name and his type
 *  
 */

trait Card {
 
 /** The name of the card
  * 
  * Its a string of any length
  *   
  */
 val name: String

 /** The type of the card
  * 
  * This val represent the type of the card, such as Climate or Combat
  */
 val tipo: String
}
