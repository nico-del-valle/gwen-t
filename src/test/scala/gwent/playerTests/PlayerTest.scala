package cl.uchile.dcc
package gwent.playerTests

import cl.uchile.dcc.gwent.model.cards.{MeleeCard, RangedCard, SiegeCard, WeatherCard}
import cl.uchile.dcc.gwent.model.player.Player

import munit.FunSuite

class PlayerTest extends FunSuite {
  val name1: String = "Geralt"
  val name2: String = "Ciri"
  var Deck1 = List()
  var Hand1 = List()
  var Hand2 = List()

  val Card1 = new MeleeCard(name1, "a", 1)
  val Card2 = new RangedCard(name2, "a", 2)
  val Card3 = new SiegeCard(name2, "a", 3  )
  val Card4 = new WeatherCard(name1, "a")

  val Deck3 = List(Card1, Card2, Card3, Card4)

  var Player1: Player = _
  var Player2: Player = _
  var Player3: Player = _
  var NoPlayer: Object = _

  override def beforeEach(context: BeforeEach): Unit = {
    Player1 = new Player(name1, Hand1, Deck1)
    Player2 = new Player(name1, Hand2 , Deck1)
    Player3 = new Player(name2, Hand2, Deck3)
    NoPlayer = new Object()
  }


    test("A player can be created with a name") {
      assertEquals(Player1.name, name1)
    }

    test("A player has initial life") {
      assertEquals(Player2.gems, 3)
    }

    test("A player has deck") {
      assert(Player1.deck == Deck1)  // empty deck

    }

    test("A player has a hand") {
      assertEquals(Player1.hand, Hand1)

    }

    test("A player can loose gems"){
      Player1.lose()
      assertEquals(Player1.gems, 2)
      Player1.lose()
      assertEquals(Player1.gems, 1)
      Player1.lose()
      assertEquals(Player1.gems, 0)
      Player1.lose()
      assertEquals(Player1.gems, 0) // It can be less than 0
    }

    test("A player can shuffle his deck"){
      val shuffled = Player3.shuffleDeck()
      assertEquals(Player3.deck.toSet , Deck3.toSet)
    }
    test("A player can draw cards from the deck to hand"){
      val drawnCard = Player3.drawCard()
      assert(!Player3.deck.contains(drawnCard))

    }

    test("After draw the deck has 1 less card"){
      val deckSize = Player3.deck.size
      Player3.drawCard()
      assertEquals(Player3.deck.size, deckSize - 1 )
    }
    test("If two player have the same name should be the same"){
      assertEquals(Player1, Player2)
      assertNotEquals(Player2, Player3)
      assertNotEquals(Player1, Player3)
    }

    test("if compare with a none Player object it returns false"){
      assert(!Player1.equals(NoPlayer))
    }


}