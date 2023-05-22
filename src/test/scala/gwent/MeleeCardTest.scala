package cl.uchile.dcc
package gwent

import munit.FunSuite

class MeleeCardTest extends FunSuite {
  val name1: String = "Geralt"
  val name2: String = "Ciri"
  val damage1: Int = 1
  val damage2: Int = 2
  val description: String = "a"



  var MeleeCard1: MeleeCard = _
  var MeleeCard2: MeleeCard = _
  var MeleeCard3: MeleeCard = _
  var NoMelee: Object = _


  override def beforeEach(context: BeforeEach): Unit = {
    MeleeCard1 = new MeleeCard(name1, description, damage1)
    MeleeCard2 = new MeleeCard(name2, description, damage2)
    MeleeCard3 = new MeleeCard(name1, description, damage1)
    NoMelee = new Object()

  }

  test("A Melee card can be created with a name") {
    assertEquals(MeleeCard1.name, name1)
  }

  test("A card has a description") {
    assertEquals(MeleeCard2.description, "a")
  }

  test("A Melee card has a damage value") {
    assertEquals(MeleeCard1.damage, damage1)
  }
  test("A melee card has a melee Cardtype"){
    assertEquals(MeleeCard1.Cardtype, "Melee")
  }
  test("A card has a currentPower"){
    assertEquals(MeleeCard1.currentPower, damage1)
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
