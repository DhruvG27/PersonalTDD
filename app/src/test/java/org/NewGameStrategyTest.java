package org;

import org.components.Dealer;
import org.components.Deck;
import org.components.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewGameStrategyTest {

    @Test
    void testInternationalNewGameSetup() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        Player player = new Player();
        NewGameStrategy strategy = new InternationalNewGameStrategy();

        assertTrue(strategy.newGame(deck, dealer, player), "The game should be set up successfully.");
        assertEquals(2, dealer.getHand().size(), "Dealer should have two cards.");
        assertEquals(2, player.getHand().size(), "Player should have two cards.");
    }

    @Test
    void testNewGameWithNullValues() {
        NewGameStrategy strategy = new InternationalNewGameStrategy();

        assertFalse(strategy.newGame(null, null, null), 
            "The game setup should fail when null values are provided.");
    }
}
