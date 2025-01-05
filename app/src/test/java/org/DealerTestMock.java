package org;

import org.components.Card;
import org.components.Dealer;
import org.enums.Suite;
import org.enums.Value;
import org.components.Deck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DealerTestMock {

    private Deck mockDeck;

    @BeforeEach
    void setUp() {
        mockDeck = Mockito.mock(Deck.class);
    }

    @Test
    void testDealerDrawsSpecificCardsFromMockDeck() {
        // Arrange: Create a mock Deck
        // Deck mockDeck = Mockito.mock(Deck.class);
        when(mockDeck.draw()).thenReturn(
            new Card(Value.ACE, Suite.HEARTS),
            new Card(Value.KING, Suite.SPADES)
        );

        Dealer dealer = new Dealer();

        // Act: Dealer draws two cards
        dealer.dealCard(mockDeck.draw());
        dealer.dealCard(mockDeck.draw());

        // Assert: Dealer's hand contains the correct cards
        assertEquals(2, dealer.getHand().size(), "Dealer should have two cards in hand.");
        assertEquals(21, dealer.calculateScore(), "Dealer's score should be 21.");
    }

    @Test
    void testDealerHandlesEmptyDeckGracefully() {
        // Arrange: Mock Deck to return null for an empty deck
        when(mockDeck.draw()).thenReturn(null);

        Dealer dealer = new Dealer();

        // Act: Dealer tries to draw a card
        dealer.dealCard(mockDeck.draw());

        // Assert: Dealer's hand should remain empty
        assertEquals(0, dealer.getHand().size(), "Dealer's hand should remain empty when deck is empty.");
    }

    @Test
    void testDealerHandlesDeckWithOneCard() {
        // Arrange: Mock Deck to return one card, then null
        when(mockDeck.draw())
            .thenReturn(new Card(Value.TEN, Suite.CLUBS))
            .thenReturn(null);

        Dealer dealer = new Dealer();

        // Act: Dealer draws two cards
        dealer.dealCard(mockDeck.draw());
        dealer.dealCard(mockDeck.draw());

        // Assert: Dealer's hand contains only one card
        assertEquals(1, dealer.getHand().size(), "Dealer's hand should contain one card.");
        assertEquals(10, dealer.calculateScore(), "Dealer's score should be 10.");
    }
    
}
