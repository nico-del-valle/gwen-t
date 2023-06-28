package cl.uchile.dcc
package gwent.cardTests

import cl.uchile.dcc.gwent.model.cards.WeatherCard
import munit.FunSuite


class WeatherCardTest extends FunSuite {
  val name1: String = "Geralt"
  val name2: String = "Ciri"
  val description: String = "a"


  var ClimateCard1: WeatherCard = _
  var ClimateCard2: WeatherCard = _
  var ClimateCard3: WeatherCard = _
  var NoClimate: Object = _

  override def beforeEach(context: BeforeEach): Unit = {
    ClimateCard1 = new WeatherCard(name1, description)
    ClimateCard2 = new WeatherCard(name1, description)
    ClimateCard3 = new WeatherCard(name2, description)
    NoClimate = new Object()
  }

  test("A climate card can be created with a name") {
    assertEquals(ClimateCard1.name, name1)
  }

  test("A climate card is a climate type card ") {
    assertEquals(ClimateCard2.Cardtype, "Weather")
  }

  test("Two cards with the same name should be the same"){
    assertEquals(ClimateCard1, ClimateCard2)
    assertNotEquals(ClimateCard2, ClimateCard3)
  }

  test("ClimateCard compared with a non-ClimateCard, return False"){
    assert(!ClimateCard1.equals(NoClimate))
  }
}