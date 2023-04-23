package cl.uchile.dcc
package gwent

import gwent.Player

import munit.FunSuite

class PlayerTest extends FunSuite {
  val name1: String = "Geralt"
  val name2: String = "Ciri"
  var Deck1 = Seq.empty
  var Hand1 = List()
  var Hand2 = List()




  var Player1: Player = _
  var Player2: Player = _
  var Player3: Player = _
  var NoPlayer: Object = _

  override def beforeEach(context: BeforeEach): Unit = {
    Player1 = new Player(name1)
    Player2 = new Player(name1)
    Player3 = new Player(name2)
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
      assert(Player1.hand.cards.toList == Hand1)

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

    test("If two player have the same name should be the same"){
      assertEquals(Player1, Player2)
      assertNotEquals(Player2, Player3)
      assertNotEquals(Player1, Player3)
    }

    test("if compare with a none Player object it returns false"){
      assert(!Player1.equals(NoPlayer))
    }


}