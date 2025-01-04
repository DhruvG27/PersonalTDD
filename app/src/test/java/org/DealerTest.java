package org;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.components.Card;
import org.components.Dealer;
import org.components.Deck;
import org.components.Player;
import org.enums.Suite;
import org.enums.Value;
import org.junit.jupiter.api.Test;

public class DealerTest {

    @Test
    void testDealerInitialization() {
        Dealer dealer = new Dealer();

        // Dealer should have an empty hand initially
        assertTrue(dealer.getHand().isEmpty(), "Dealer should start with an empty hand.");
    }

    @Test
    void testDealerDealsCardToSelf() {
        Dealer dealer = new Dealer();
        Card card = new Card(Value.ACE, Suite.HEARTS);

        dealer.dealCard(card);

        // Dealer's hand should contain the card
        assertEquals(1, dealer.getHand().size(), "Dealer's hand should contain one card.");
        assertTrue(dealer.getHand().contains(card), "Dealer's hand should contain the dealt card.");
    }

    @Test
    void testDealerDrawsUntilSeventeen() {
        Dealer dealer = new Dealer();
        Deck deck = new Deck(); // Assume a full deck is available

        dealer.drawCards(deck);

        // Dealer's total score should be at least 17
        int dealerScore = dealer.calculateScore();
        assertTrue(dealerScore >= 17, "Dealer's score should be at least 17 after drawing.");
    }

    @Test
    void testDealerRevealsOneCard() {
        Dealer dealer = new Dealer();
        Card hiddenCard = new Card(Value.ACE, Suite.SPADES);
        Card revealedCard = new Card(Value.TEN, Suite.HEARTS);

        dealer.dealCard(hiddenCard);
        dealer.dealCard(revealedCard);

        String visibleCard = dealer.revealCard();

        assertEquals("Ten of Hearts", visibleCard, "Dealer should reveal only the first card in the hand.");
    }

    @Test
    void testDealerResetsHand() {
        Dealer dealer = new Dealer();
        Card card = new Card(Value.ACE, Suite.SPADES);
        dealer.dealCard(card);

        dealer.resetHand();

        assertTrue(dealer.getHand().isEmpty(), "Dealer's hand should be empty after resetting.");
    }

    @Test
    void testDetermineWinner() {
        Dealer dealer = new Dealer();
        Player player = new Player();

        dealer.dealCard(new Card(Value.KING, Suite.SPADES)); // Dealer has 20
        dealer.dealCard(new Card(Value.JACK, Suite.HEARTS));

        player.dealCard(new Card(Value.TEN, Suite.DIAMONDS)); // Player has 21
        player.dealCard(new Card(Value.ACE, Suite.CLUBS));

        String winner = dealer.determineWinner(player);

        assertEquals("Player", winner, "Player should win with a score of 21 against Dealer's 20.");
    }

    @Test
    void testDealerScoreCalculation() {
        Dealer dealer = new Dealer();
        dealer.dealCard(new Card(Value.QUEEN, Suite.DIAMONDS));
        dealer.dealCard(new Card(Value.FIVE, Suite.HEARTS));

        assertEquals(15, dealer.calculateScore(), "Dealer should correctly calculate score.");
    }

}
