package cl.uchile.dcc
package gwent.model.cards

import gwent.model.player.Player

import jdk.incubator.concurrent.ScopedValue.Carrier

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

 /** The description of the card
  * 
  * This val represent the type of the card, such as Climate or Combat
  */
 val description: String
 
 def addCard(player: Player): Unit

 def removeCard(player: Player): Unit



}
