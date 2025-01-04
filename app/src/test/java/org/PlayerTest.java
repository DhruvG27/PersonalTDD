package org;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.components.Card;
import org.components.Player;
import org.components.Person;
import org.enums.Suite;
import org.enums.Value;
import org.junit.jupiter.api.Test;

import org.components.Player;

public class PlayerTest {

  @Test
  void initializationTest() {
    Player player = new Player();

    // player should have an empty hand
    assertTrue(player.getHand().size() == 0);
  }

  @Test
  void testDealCardToPlayer() {
    Player player = new Player();
    Card c = new Card(Value.ACE, Suite.SPADES);
    player.dealCard(c);

    // dealt card should be in the hand of the player
    assertTrue(player.getHand().contains(c));
    assertEquals(player.getHand().size(), 1);

    Card c2 = new Card(Value.TEN, Suite.DIAMONDS);
    player.dealCard(c2);
    assertTrue(player.getHand().contains(c2));
    assertEquals(player.getHand().size(), 2);

    Card c3 = new Card(Value.KING, Suite.CLUBS);
    player.dealCard(c3);
    assertTrue(player.getHand().contains(c3));
    assertEquals(player.getHand().size(), 3);
  }

  @Test
  void testClearHand() {
    Player player = new Player();
    Card c = new Card(Value.ACE, Suite.SPADES);
    Card c2 = new Card(Value.TEN, Suite.DIAMONDS);
    Card c3 = new Card(Value.KING, Suite.CLUBS);
    player.dealCard(c);
    player.dealCard(c2);
    player.dealCard(c3);

    assertEquals(player.getHand().size(), 3);
    player.clearHand();
    assertEquals(player.getHand().size(), 0);
  }

  @Test
  void testShowHand() {
    Player player = new Player();
    Card c = new Card(Value.ACE, Suite.SPADES);
    player.dealCard(c);

    assertEquals(player.getHand().get(0).toString(), "Hidden");
    player.showHand();
    StringBuilder s = new StringBuilder();
    s.append(c.getValue().getDisplayName());
    s.append(" of ");
    s.append(c.getSuite().getDisplayName());
    assertEquals(player.getHand().get(0).toString(), s.toString());

  }

  @Test
  void testHasAce() {
    Player player = new Player();
    Card c = new Card(Value.ACE, Suite.SPADES);
    player.dealCard(c);
    assertTrue(player.hasAce());
    player.clearHand();
    assertFalse(player.hasAce());
  }

  @Test
  void testCalcScore() {
    Player player = new Player();
    Card c = new Card(Value.ACE, Suite.SPADES);
    Card c2 = new Card(Value.TEN, Suite.DIAMONDS);
    Card c3 = new Card(Value.TEN, Suite.CLUBS);
    player.dealCard(c);
    player.dealCard(c2);
    player.dealCard(c3);

    int score = player.calculateScore();

    assertEquals(21, score);

    player.clearHand();

    c = new Card(Value.THREE, Suite.SPADES);
    c2 = new Card(Value.FIVE, Suite.DIAMONDS);
    c3 = new Card(Value.FOUR, Suite.CLUBS);
    player.dealCard(c);
    player.dealCard(c2);
    player.dealCard(c3);

    int score2 = player.calculateScore();
    assertEquals(12, score2);

    player.clearHand();

    c = new Card(Value.ACE, Suite.SPADES);
    c2 = new Card(Value.TEN, Suite.DIAMONDS);
    player.dealCard(c);
    player.dealCard(c2);
    int score3 = player.calculateScore();
    assertEquals(21, score3);
  }

  @Test
  void testPlayerScoreCalculation() {
      Player player = new Player();
      player.dealCard(new Card(Value.KING, Suite.SPADES));
      player.dealCard(new Card(Value.ACE, Suite.CLUBS));
  
      assertEquals(21, player.calculateScore(), "Player should correctly calculate blackjack score.");
  }
  
}
