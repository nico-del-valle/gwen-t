package cl.uchile.dcc
package gwent

import munit.FunSuite


class SiegeCardTest extends FunSuite {
  val name1: String = "Geralt"
  val name2: String = "Ciri"
  val damage1: Int = 1
  val damage2: Int = 2


  var SiegeCard1: SiegeCard = _
  var SiegeCard2: SiegeCard = _
  var SiegeCard3: SiegeCard = _
  var NoSiege: Object = _

  override def beforeEach(context: BeforeEach): Unit = {
    SiegeCard1 = new SiegeCard(name1, damage1)
    SiegeCard2 = new SiegeCard(name2, damage2)
    NoSiege = new Object()
  }

  test("A Siege card can be created with a name") {
    assertEquals(SiegeCard1.name, name1)
  }

  test("A Siege card is a combat card Type (tipo) ") {
    assertEquals(SiegeCard2.tipo, "Combat")
  }

  test("A Siege card can be created with damage value") {
    assertEquals(SiegeCard1.damage, damage1)
  }

  test("A combat card can gain or lose damage ") {
    SiegeCard1.DamageChange(1)
    assertEquals(SiegeCard1.damage, 2)
    SiegeCard2.DamageChange(-3)
    assertEquals(SiegeCard2.damage, 1) // damage can be less than 1
  }

  test("SiegeCard compared with a non-SiegeCard, return False") {
    assert(!SiegeCard1.equals(NoSiege))
  }
}