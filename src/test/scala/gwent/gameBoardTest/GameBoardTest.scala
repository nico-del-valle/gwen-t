package cl.uchile.dcc
package gwent.gameBoardTest

import cl.uchile.dcc.gwent.model.cards.{Card, MeleeCard, RangedCard, SiegeCard, WeatherCard }
import cl.uchile.dcc.gwent.model.gameBoard.WeatherBoard
import cl.uchile.dcc.gwent.model.player.Player
import munit.FunSuite

class GameBoardTest extends FunSuite {
  val name1: String = "Geralt"
  val name2: String = "Ciri"
  val escarcha: String = "Escarcha Mordiente"
  val niebla: String = "Niebla Impenetrable"
  val lluvia: String = "Lluvia Torrencial"
  val damage1: Int = 3
  val damage2: Int = 2
  val description: String = "a"


  var meleeCard: MeleeCard = _
  var rangedCard: RangedCard = _
  var siegeCard: SiegeCard = _
  var weatherCard: WeatherCard = _
  var EscarchaCard: WeatherCard = _
  var NieblaCard: WeatherCard = _
  var LluviaCard: WeatherCard = _

  var P1: Player = _
  var P2: Player = _


  override def beforeEach(context: BeforeEach): Unit = {
    meleeCard = new MeleeCard(name1, description, damage1)
    rangedCard = new RangedCard(name2, description, damage2)
    siegeCard = new SiegeCard(name1, description, damage2)
    weatherCard = new WeatherCard (name1, description)
    EscarchaCard = new WeatherCard(escarcha, description)
    NieblaCard = new WeatherCard(niebla, description)
    LluviaCard = new WeatherCard(lluvia, description)

    P1 = new Player("Yo", List(meleeCard,rangedCard,siegeCard,weatherCard), List())
    P2 = new Player("No yo", List(meleeCard,rangedCard,siegeCard,weatherCard), List())
  }


  test("you can add a card to the board and it goes to its specific place "){
    meleeCard.addCard(P1)
    siegeCard.addCard(P1)
    rangedCard.addCard(P1)
    siegeCard.addCard(P2)
    weatherCard.addCard(P2)
    NieblaCard.addCard(P1)


    assertEquals (P1.meleeBoard.cards, List(meleeCard))
    assertEquals(P1.rangedBoard.cards, List(rangedCard))
    assertEquals(P1.siegeBoard.cards, List(siegeCard))
    assertEquals(P2.meleeBoard.cards, List())
    assertEquals(P2.siegeBoard.cards, List(siegeCard))
    assertEquals(WeatherBoard.cards, Option(NieblaCard))
    assertEquals(WeatherBoard.cards, Option(NieblaCard))

  }


test("you can remove cards from the board") {
  meleeCard.addCard(P1)
  rangedCard.addCard(P1)
  siegeCard.addCard(P1)

  meleeCard.addCard(P2)
  rangedCard.addCard(P2)
  siegeCard.addCard(P2)

  weatherCard.addCard(P1)

  meleeCard.removeCard(P1)
  rangedCard.removeCard(P1)
  siegeCard.removeCard(P1)
  meleeCard.removeCard(P2)
  rangedCard.removeCard(P2)
  siegeCard.removeCard(P2)

  weatherCard.removeCard(P1)


  assertEquals(P1.meleeBoard.cards, List())
  assertEquals(P1.rangedBoard.cards, List())
  assertEquals(P1.siegeBoard.cards, List())

  assertEquals(P2.meleeBoard.cards, List())
  assertEquals(P2.rangedBoard.cards, List())
  assertEquals(P2.siegeBoard.cards, List())
  assertEquals(WeatherBoard.cards, None)
}





  test("you can clear the board") {

    meleeCard.addCard(P1)
    siegeCard.addCard(P2)
    rangedCard.addCard(P2)
    NieblaCard.addCard(P2)

    P1.clearPlayerBoard()
    P2.clearPlayerBoard()

    assertEquals(P1.meleeBoard.cards, List())
    assertEquals(P1.rangedBoard.cards, List())
    assertEquals(P1.siegeBoard.cards, List())
    assertEquals(P2.meleeBoard.cards, List())
    assertEquals(P2.rangedBoard.cards, List())
    assertEquals(P2.siegeBoard.cards, List())
    assertEquals(WeatherBoard.cards, None)

  }

    test("You can calculate actual power"){
      meleeCard.addCard(P1)
      rangedCard.addCard(P1)
      siegeCard.addCard(P1)
      val damage = P1.calculateDamage()
      assertEquals(damage, 7)
    }

    test("if you use a weather card with name 'Escarcha Mordiente', all the melee card has 1 current power"){
      meleeCard.addCard(P1)
      rangedCard.addCard(P1)
      siegeCard.addCard(P1)
      EscarchaCard.addCard(P1)

      val damage =P1.calculateDamage()
      assertEquals(damage, 5 ) // original = 3 + 2 + 2 = 7, after = 1 + 2 + 2 = 5

    }

    test("if you use a weather card with name 'Niebla Impenetrable', all the ranged card has 1 current power") {
      meleeCard.addCard(P1)
      rangedCard.addCard(P1)
      siegeCard.addCard(P1)
      NieblaCard.addCard(P1)

      val damage = P1.calculateDamage()
      assertEquals(damage, 6) // original = 3 + 2 + 2 = 7, after = 3 + 1 + 2 = 6
    }

    test("if you use a weather card with name 'Lluvia Torrencial', all the siege card has 1 current power") {
      meleeCard.addCard(P1)
      rangedCard.addCard(P1)
      siegeCard.addCard(P1)
      LluviaCard.addCard(P1)

      val damage = P1.calculateDamage()
      assertEquals(damage, 6) // original = 3 + 2 + 2 = 7, after = 3 + 2 + 1 = 6
    }

    test("if the player uses a hand, the card is no more is his hand"){
      meleeCard.addCard(P1)
      weatherCard.addCard(P1)

      assertEquals(P1.hand, List(rangedCard,siegeCard))

      rangedCard.addCard(P2)
      siegeCard.addCard(P2)

      assertEquals(P2.hand, List(meleeCard,weatherCard))
    }





}

