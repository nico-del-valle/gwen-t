package cl.uchile.dcc
package gwent

import gwent.{Card, Player}

import munit.FunSuite

class DeckTest extends FunSuite {

  // we create a set of cards
  // to simplify the test we are gonna use only 5 cards (30 in the real game)

  val Card1 = new MeleeCard("Geralt",5)
  val Card2 = new MeleeCard("Ciri",5)
  val Card3 = new RangedCard("Triss",4)
  val Card4 = new SiegeCard("Siege",2)
  val Card5 = new ClimateCard("Sun")
  val deck1 = Seq(Card1,Card2,Card3,Card4,Card5)

  var Deck1: Deck = _
  var Deck2: Deck = _


  override def beforeEach(context: BeforeEach): Unit = {
    Deck1 = new Deck()
    Deck2 = new Deck(deck1)

  }

  test("Deck can be created with no cards") {
    assertEquals(Deck1.cards, Seq.empty) // empty Deck
  }

  test("Deck can be created with a set of cards"){
    assertEquals(Deck2.cards, deck1)

  }


  test("We can draw cards from the deck"){
    Deck2.draw(3)
    assertEquals(Deck2.cards, Seq(Card4,Card5))
    Deck2.draw(3)
    assertEquals(Deck2.cards, Seq.empty[Card]) // if we draw more cards than cards in the deck
  }

  test("We can shuffle the deck"){
    val rnd = new scala.util.Random(42)
    Deck2.shuffle()
    assertNotEquals(Deck2.cards,Seq(Card1,Card2,Card3,Card4,Card5 )) 
    // there is a chance, the original list its the same as the original
  }

}
