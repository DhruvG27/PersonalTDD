package org;

import org.components.Card;
import org.components.Dealer;
import org.components.EnglishView;
import org.components.Player;
import org.enums.Suite;
import org.enums.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EnglishViewTest {

    private Player mockPlayer;
    private Dealer mockDealer;
    private EnglishView view;

    @BeforeEach
    void setup() {
        mockPlayer = Mockito.mock(Player.class);
        mockDealer = Mockito.mock(Dealer.class);
        view = new EnglishView();
    }

    @Test
    void testDisplayPlayerHand() {
        // Arrange: Mock the player's hand
        List<Card> playerHand = Arrays.asList(
                new Card(Value.ACE, Suite.SPADES),
                new Card(Value.KING, Suite.HEARTS));
        when(mockPlayer.getHand()).thenReturn(playerHand);

        // Act: Render the player's hand
        String renderedHand = view.renderPlayerHand(mockPlayer);

        // Assert: Check if the rendered output matches the expected format
        String expectedOutput = "Player's hand: Ace of Spades, King of Hearts";
        assertEquals(expectedOutput, renderedHand, "The view should correctly display the player's hand.");
    }

    @Test
    void testDisplayDealerHand() {
        // Arrange: Mock the dealer's hand
        List<Card> dealerHand = Arrays.asList(
                new Card(Value.QUEEN, Suite.DIAMONDS),
                new Card(Value.THREE, Suite.HEARTS));
        when(mockDealer.getHand()).thenReturn(dealerHand);

        // Act: Render the dealer's hand
        String renderedHand = view.renderDealerHand(mockDealer);

        // Assert: Check if the rendered output matches the expected format
        String expectedOutput = "Dealer's hand: Queen of Diamonds, Hidden";
        assertEquals(expectedOutput, renderedHand, "The view should correctly display the dealer's hand.");
    }

    @Test
    void testDisplayDealerHandFailsOnMultipleVisibleCards() {
        // Arrange: Mock the dealer's hand
        List<Card> dealerHand = Arrays.asList(
                new Card(Value.QUEEN, Suite.DIAMONDS),
                new Card(Value.THREE, Suite.HEARTS),
                new Card(Value.SEVEN, Suite.SPADES));
        when(mockDealer.getHand()).thenReturn(dealerHand);

        // Act: Render the dealer's hand
        String renderedHand = view.renderDealerHand(mockDealer);

        // Assert: Fail for showing more than one visible card
        String expectedOutput = "Dealer's hand: Queen of Diamonds, Hidden, Hidden";
        assertEquals(expectedOutput, renderedHand, "The view should only show the first card and hide the rest.");
    }

}
