package cl.uchile.dcc
package gwent

import munit.FunSuite


class RangedCardTest extends FunSuite {
  val name1: String = "Geralt"
  val name2: String = "Ciri"
  val damage1: Int = 1
  val damage2: Int = 2


  var RangedCard1: RangedCard = _
  var RangedCard2: RangedCard = _
  var RangedCard3: RangedCard = _
  var NoRanged: Object = _


  override def beforeEach(context: BeforeEach): Unit = {
    RangedCard1 = new RangedCard(name1, damage1)
    RangedCard2 = new RangedCard(name2, damage2)
    RangedCard3 = new RangedCard(name1, damage1)
    NoRanged = new Object()

  }

  test("A Ranged card can be created with a name") {
    assertEquals(RangedCard1.name, name1)
  }

  test("A Ranged card is a Combat type card ") {
    assertEquals(RangedCard2.tipo, "Combat")
  }

  test("A Ranged card has a damage value") {
    assertEquals(RangedCard1.damage, damage1)
  }

  test("A combat card can gain or lose damage ") {
    RangedCard1.DamageChange(1)
    assertEquals(RangedCard1.damage, 2)
    RangedCard2.DamageChange(-3)
    assertEquals(RangedCard2.damage, 1) // damage can be less than 1
  }

  test("If two cards have the same name should be the same") {
    assertEquals(RangedCard1, RangedCard3)
    assertNotEquals(RangedCard1, RangedCard2)
    assertNotEquals(RangedCard1, RangedCard2)
  }

  test("RangedCard compared with a non-RangedCard, return False") {
    assert(!RangedCard1.equals(NoRanged))
  }
}
