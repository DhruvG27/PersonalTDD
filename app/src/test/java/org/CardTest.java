package org;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.components.Card;
import org.enums.Suite;
import org.enums.Value;
import org.junit.jupiter.api.Test;

public class CardTest {

  @Test
  void testSuiteEnum() {
    Suite suite = Suite.HEARTS;
    assertEquals(suite.getDisplayName(), "Hearts");
  }

  @Test
  void testValueEnum() {
    Value value = Value.JACK;
    assertEquals(value.getDisplayName(), "Jack");
  }

  @Test
  void testShowCard() {

    Suite suite = Suite.HEARTS;
    Value value = Value.QUEEN;

    Card card = new Card(value, suite);

    assertEquals(card.isHidden(), true);
    assertEquals(card.toString(), "Hidden");

    card.show();
    assertEquals(card.isHidden(), false);
    assertEquals(card.toString(), "Queen of Hearts");

  }

  @Test
  void testGetCardVaLue() {

    Suite suite = Suite.HEARTS;
    Value value = Value.KING;

    Card card = new Card(value, suite);

    assertEquals(card.getValue(), Value.KING);
  }

  @Test
  void testGetCardSuite() {

    Suite suite = Suite.DIAMONDS;
    Value value = Value.KING;

    Card card = new Card(value, suite);

    assertEquals(card.getSuite(), Suite.DIAMONDS);
  }

  @Test
  void testGetScore() {
    Suite suite = Suite.DIAMONDS;
    Value value = Value.KING;

    Card card = new Card(value, suite);

    assertEquals(card.getScore(), 10);

    Suite suite2 = Suite.HEARTS;
    Value value2 = Value.TWO;

    Card card2 = new Card(value2, suite2);

    assertEquals(card2.getScore(), 2);

  }

}
