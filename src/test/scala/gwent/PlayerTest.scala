package cl.uchile.dcc
package gwent

import munit.FunSuite

class PlayerTest extends FunSuite {
  val name = "Geralt"

  //we create a Array of 5 card to test (30 in the real game)
  val card1 = new Card("Ciri", "Unit", "Close Combat", 8)
  val card2 = new Card("Yennefer", "Unit", "Ranged Combat", 7)
  val card3 = new Card("Triss", "Unit", "Ranged Combat",6)
  val card4 = new Card("Jaskier", "Unit", "Siege", 4)
  val card5 = new Card("Catapult", "Unit", "Siege", 4)

  val cardDeck: Array[Object] = Array(card1, card2, card3, card4, card5)

  val cardHand: Array[Object] = Array() // hand without cards

  

  test("A Player can be created with a name") {
    var player = new Player(name, 2, cardDeck, cardHand )
    assertEquals(player.name, name)
  }


  test("A Player can be created with gems that represents his life points") {
    var player = new Player(name, 2 , cardDeck, cardHand)
    assertEquals(player.gem, 2)
  }

  test("The player can lose a gem"){
    var player = new Player(name, 2, cardDeck, cardHand)
    player.lose()
    assertEquals(player.gem, 1) // from 2 gems to 1 gem

  }


  test("A player is created with a card Deck") {
    var player = new Player (name, 2 , cardDeck, cardHand)
    assertEquals(player.cardDeck, cardDeck)
  }



  test("A Player have cards in his hand"){
    var player = new Player(name, 2, cardDeck, cardHand)
    assertEquals(player.cardHand, cardHand )  // we test when the hand has 0 cards

  }

  test("A player can draw cards from the deck to his hand") {
    var player = new Player(name, 2, cardDeck, cardHand)

    //test when we have more than 3 cards in the deck
    var cardsDrawn = player.draw3()
    assertEquals(player.cardHand.toSeq, cardsDrawn.toSeq) // we test if the card drawn from the deck goes to the hand

    //test when we less than 3 cards in the deck
    cardsDrawn = cardsDrawn ++ player.draw3()
    assertEquals(player.cardHand.toSeq, cardsDrawn.toSeq)

    //no card in the deck
    cardsDrawn = cardsDrawn ++ player.draw3()
    assertEquals(player.cardHand.length, 5)  // the hand has all the cards (5)
    assertEquals(player.cardDeck.length, 0)  // the deck has no cards
  }

}