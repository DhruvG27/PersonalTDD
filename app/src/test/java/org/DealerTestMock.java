package org;

import org.components.Card;
import org.components.Dealer;
import org.enums.Suite;
import org.enums.Value;
import org.components.Deck;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DealerTestMock {
    @Test
    void testDealerDrawsSpecificCardsFromMockDeck() {
        // Arrange: Create a mock Deck
        Deck mockDeck = Mockito.mock(Deck.class);
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
    
}
