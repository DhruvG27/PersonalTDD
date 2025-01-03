package org;

import static org.junit.jupiter.api.Assertions.*;

import org.checkerframework.checker.units.qual.t;
import org.components.Card;
import org.components.Deck;
import org.enums.Suite;
import org.enums.Value;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeckTest {

    // Test the initialization of the deck
    /*
     * This test validates that the deck is initialized with 52 cards.
     * It checks only the total count and does not validate uniqueness.
     * WILL PASS THIS TIME AS CODE LOGIC IS CORRECT
     */
    @Test
    void testDeckInitialization() {
        // Create a deck
        Deck deck = new Deck();

        // Check that it has 52 cards
        assertEquals(52, deck.getCards().size(), "Deck should contain exactly 52 cards.");
    }

    // Test to check for duplicates in the deck
    /*
     * This test validates that there are no duplicate cards in the deck.
     * WILL PASS THIS TIME AS CODE LOGIC IS CORRECT
     */
    @Test
    void testDeckHasNoDuplicates() {
        // Create a deck
        Deck deck = new Deck();

        // Check for duplicates
        Set<Card> uniqueCards = new HashSet<>(deck.getCards());

        // Assert that the number of unique cards matches the total number of cards
        assertEquals(deck.getCards().size(), uniqueCards.size(), "Deck contains duplicate cards!");
    }
    // Both test cases will pass this time as the code logic is correct.

    // Added more test to check code logic
    @Test
    void testDeckContainsOnlyCards() {
        Deck deck = new Deck();
        List<Card> cards = deck.getCards();

        for (Object card : cards) {
            assertTrue(card instanceof Card, "Deck contains an object that is not a Card.");
        }
    }

    // Test that the deck has the correct total number of suites
    @Test
    void testDeckContainsAllSuites() {
        Deck deck = new Deck();
        Set<Object> suites = new HashSet<>();

        for (Card card : deck.getCards()) {
            suites.add(card.getSuite());
        }

        assertEquals(4, suites.size(), "Deck does not contain all 4 suites.");
    }

    // Test that the deck has the correct total number of values
    @Test
    void testDeckContainsAllValues() {
        Deck deck = new Deck();
        Set<Object> values = new HashSet<>();

        for (Card card : deck.getCards()) {
            values.add(card.getValue());
        }

        assertEquals(13, values.size(), "Deck does not contain all 13 values.");
    }

    // Test that the deck does not contain any extra cards
    @Test
    void testDeckFailForExtraCards() {
        Deck deck = new Deck();
        assertFalse(deck.getCards().size() > 52, "Deck contains more than 52 cards, which is incorrect.");
    }

    // Test that the deck does not contain any null cards
    @Test
    void testDeckDoesNotContainNullCards() {
        Deck deck = new Deck();
        for (Card card : deck.getCards()) {
            assertNotNull(card, "Deck contains a null card, which is not allowed.");
        }
    }

    // Added a failing test to verify that shuffle method changes the order of cards
    // but total number of cards remains the same
    // TEST WILL PASS AS THE CODE FOR SHUFFLE METHOD IS CORRECT test should now pass
    // because the deck order is sufficiently randomized.

    @Test
    void testDeckHalfCardsChangePositionAfterShuffle() {
        Deck deck = new Deck();
        List<Card> originalOrder = new ArrayList<>(deck.getCards());

        deck.shuffle(); // Apply shuffle logic

        // Count the number of cards that have moved from their original positions
        int changedPositions = 0;
        for (int i = 0; i < originalOrder.size(); i++) {
            if (!originalOrder.get(i).equals(deck.getCards().get(i))) {
                changedPositions++;
            }
        }

        // Assert that more than half the deck changes position
        assertTrue(changedPositions > 26, "More than half the deck should change position after shuffling.");
    }

    // Test will pass shuffle works correctly
    // logic might fail because it doesn’t randomize the deck enough to produce a
    // wide distribution of changes.
    @Test
    void testDeckEnsuresGlobalRandomness() {
        Deck deck = new Deck();
        List<Card> originalOrder = new ArrayList<>(deck.getCards());

        for (Card c : originalOrder) {
            c.show();
        }

        for (Card c : deck.getCards()) {
            c.show();
        }

        deck.shuffle(); // Apply shuffle logic

        for (Card c : deck.getCards()) {
            c.show();
            System.out.println(c);
        }

        // Ensure cards are evenly distributed across the deck
        int[] positionChangeCounts = new int[52]; // Tracks position changes for each card
        for (int i = 0; i < originalOrder.size(); i++) {
            int newIndex = deck.getCards().indexOf(originalOrder.get(i));
            int positionChange = Math.abs(newIndex - i);
            positionChangeCounts[i] = positionChange;
        }

        // Check for a reasonable distribution of position changes
        boolean hasWideDistribution = false;
        for (int change : positionChangeCounts) {
            if (change > 10) { // More than 10 cards moved by this amount
                hasWideDistribution = true;
                break;
            }
        }

        assertTrue(hasWideDistribution,
                "The shuffle should create a wide distribution of position changes.");
    }

    @Test
    void testGetCard() {
        Deck d = new Deck();

        Card c = d.drawCard();

        // check if a card is returned
        assertNotNull(c);
        // check if the card was taken from the deck
        assertFalse(d.getCards().contains(c));

    }

    @Test
    void testGetCardFromEmptyDeck() {
        Deck d = new Deck();

        for (int i = 0; i < 52; i++) {
            d.drawCard();
        }

        // try to get a card from the empty deck

        assertNull(d.drawCard());

    }

    @Test
    void testToAddACardToTheDeck() {
        Deck d = new Deck();
        Card c = d.drawCard();

        d.addCard(c);
        assertTrue(d.getCards().contains(c));
    }

    @Test
    void testToAddCardToAFullDeck() {
        Deck d = new Deck();
        Card c = new Card(Value.ACE, Suite.CLUBS);

        // You should not be able to add a card that exists or if the deck is full
        assertFalse(d.addCard(c));

    }

    @Test
    void testToAddNullCard() {
        Deck d = new Deck();
        Card c = null;

        // You should not be able to add a null card
        assertFalse(d.addCard(c));

    }
}
