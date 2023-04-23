package cl.uchile.dcc
package gwent

import munit.FunSuite


class ClimateCardTest extends FunSuite {
  val name1: String = "Geralt"
  val name2: String = "Ciri"


  var ClimateCard1: ClimateCard = _
  var ClimateCard2: ClimateCard = _
  var ClimateCard3: ClimateCard = _
  var NoClimate: Object = _

  override def beforeEach(context: BeforeEach): Unit = {
    ClimateCard1 = new ClimateCard(name1)
    ClimateCard2 = new ClimateCard(name1)
    ClimateCard3 = new ClimateCard(name2)
    NoClimate = new Object()
  }

  test("A climate card can be created with a name") {
    assertEquals(ClimateCard1.name, name1)
  }

  test("A climate card is a climate type card ") {
    assertEquals(ClimateCard2.tipo, "Climate")
  }

  test("Two cards with the same name should be the same"){
    assertEquals(ClimateCard1, ClimateCard2)
    assertNotEquals(ClimateCard2, ClimateCard3)
  }

  test("ClimateCard compared with a non-ClimateCard, return False"){
    assert(!ClimateCard1.equals(NoClimate))
  }
}