package org;

import org.components.Player;
import org.enums.Suite;
import org.enums.Value;
import org.components.Card;
import org.components.EnglishView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class EnglishViewTest {

    private Player player;
    private EnglishView view;

    @BeforeEach
    void setup() {
        player = new Player();
        view = new EnglishView();
    }

    @Test
    void testDisplayPlayerHand() {
        // Arrange: Add cards to the player's hand
        player.dealCard(new Card(Value.ACE, Suite.SPADES));
        player.dealCard(new Card(Value.KING, Suite.HEARTS));

        // Act: Render the player's hand
        String renderedHand = view.renderPlayerHand(player);

        // Assert: Check if the rendered output matches the expected format
        String expectedOutput = "Player's hand: Ace of Spades, King of Hearts";
        assertEquals(expectedOutput, renderedHand, "The view should correctly display the player's hand.");
    }
}
