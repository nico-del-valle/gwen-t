package cl.uchile.dcc
package gwent

import munit.FunSuite

class MeleeCardTest extends FunSuite {
  val name1: String = "Geralt"
  val name2: String = "Ciri"
  val damage1: Int = 1
  val damage2: Int = 2



  var MeleeCard1: MeleeCard = _
  var MeleeCard2: MeleeCard = _
  var MeleeCard3: MeleeCard = _
  var NoMelee: Object = _


  override def beforeEach(context: BeforeEach): Unit = {
    MeleeCard1 = new MeleeCard(name1, damage1)
    MeleeCard2 = new MeleeCard(name2, damage2)
    MeleeCard3 = new MeleeCard(name1,damage1)
    NoMelee = new Object()

  }

  test("A Melee card can be created with a name") {
    assertEquals(MeleeCard1.name, name1)
  }

  test("A Melee card is a Combat type card ") {
    assertEquals(MeleeCard2.tipo, "Combat")
  }

  test("A Melee card has a damage value") {
    assertEquals(MeleeCard1.damage, damage1)
  }

  test("A combat card can gain or lose damage "){
    MeleeCard1.DamageChange(1)
    assertEquals(MeleeCard1.damage, 2)
    MeleeCard2.DamageChange(-3)
    assertEquals(MeleeCard2.damage, 1) // the minimun damage is 1
  }

  test("If two cards have the same name should be the same"){
    assertEquals(MeleeCard1,MeleeCard3)
    assertNotEquals(MeleeCard1,MeleeCard2)
    assertNotEquals(MeleeCard2,MeleeCard3)
  }

  test("MeleeCard compared with a non-MeleeCard, return False") {
    assert(!MeleeCard1.equals(NoMelee))
  }

}
