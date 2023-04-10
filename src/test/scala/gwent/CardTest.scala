package cl.uchile.dcc
package gwent

import munit.FunSuite

class CardTest extends FunSuite {
  



  test("The card can be created with a name"){
    var card = new Card("Ciri", "Unit", "Close Combat", 8 )
    assertEquals(card.name,"Ciri")
    var card2 = new Card(null, "Unit", "Close Combat", 8 )
    assertEquals(card2.name, null)
  }


  test("The card has a class type"){
    var card = new Card("Ciri", "Unit", "Close Combat", 8 )
    assertEquals(card.cardClass, "Unit")
  }

  test("The card has card Category"){
    var card = new Card("Ciri", "Unit", "Close Combat", 8 )
    assertEquals(card.cardCategory, "Close Combat")


  }

  test("Card has a damage value"){
    var card = new Card("Ciri", "Unit", "Close Combat", 8 )
    assertEquals(card.damage, 8)
    var card2 = new Card("Ciri", "Unit", "Close Combat", 0 )
    assertEquals(card2.damage, 0)
  }

  test("Card lose damage points"){
    var card = new Card("Ciri", "Unit", "Close Combat", 8 )
    var card2 = new Card("Ciri", "Unit", "Close Combat", 8 )
    card.AtkLose(2)
    card2.AtkLose(9)
    assertEquals(card.damage, 6)
    assertEquals(card2.damage, 0) // if we reach a negative damage value, the damage is 0
  }

  test("Card gained damage points"){
    var card = new Card("Ciri", "Unit", "Close Combat", 8 )
    card.AtkGain(1)
    assertEquals(card.damage, 9)
  }

}
