package cl.uchile.dcc
package gwent.cardTests

import cl.uchile.dcc.gwent.model.cards.SiegeCard
import munit.FunSuite


class SiegeCardTest extends FunSuite {
  val name1: String = "Geralt"
  val name2: String = "Ciri"
  val damage1: Int = 1
  val damage2: Int = 2
  val description: String = "a"


  var SiegeCard1: SiegeCard = _
  var SiegeCard2: SiegeCard = _
  var SiegeCard3: SiegeCard = _
  var NoSiege: Object = _

  override def beforeEach(context: BeforeEach): Unit = {
    SiegeCard1 = new SiegeCard(name1, description, damage1)
    SiegeCard2 = new SiegeCard(name2, description, damage2)
    NoSiege = new Object()
  }

  test("A Siege card can be created with a name") {
    assertEquals(SiegeCard1.name, name1)
  }
  
  test("A Siege card can be created with damage value") {
    assertEquals(SiegeCard1.damage, damage1)
  }
  test("A card has a currentPower") {
    assertEquals(SiegeCard1.currentPower, damage1)
  }


  test("SiegeCard compared with a non-SiegeCard, return False") {
    assert(!SiegeCard1.equals(NoSiege))
  }
}