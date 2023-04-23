package cl.uchile.dcc
package gwent

import gwent.{Card, Player}

import munit.FunSuite

class  HandTest extends FunSuite {

  // we create a set of cards
  // to simplify the test we are gonna use only 5 cards (30 in the real game)

  val Card1 = new MeleeCard("Geralt", 5)
  val Card2 = new MeleeCard("Ciri", 5)
  val Card3 = new RangedCard("Triss", 4)
  val Card4 = new SiegeCard("Siege", 2)
  val Card5 = new ClimateCard("Sun")

  val list1 = List.empty[Card]
  val list2 = List(Card2,Card1)
  var Hand1: Hand = _
  var Hand2: Hand = _


  override def beforeEach(context: BeforeEach): Unit = {
    Hand1 = new Hand()
    Hand2 = new Hand(list2)

  }


  test("A hand can have no cards"){
    assertEquals(Hand1.cards, list1)


  }

  test(" We can add cards to the hand"){
    Hand1.add(Card1)
    Hand1.add(Card2)
    assertEquals(Hand1.cards, List(Card2, Card1))
    Hand1.add(Card2)
    assertEquals(Hand1.cards, List(Card2,Card2, Card1)) // we add the same card two times
  }

  test("We can remove cards from the hand"){
    Hand2.remove(Card1)
    assertEquals(Hand2.cards, List(Card2))
    Hand1.remove(Card1)     // what happen if we try to remove a card that its not in the Hand
    assertEquals(Hand1.cards, List())
  }

}

