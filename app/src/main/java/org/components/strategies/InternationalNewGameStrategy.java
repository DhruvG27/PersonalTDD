package org.components.strategies;

import org.components.Dealer;
import org.components.Deck;
import org.components.Player;

public class InternationalNewGameStrategy implements NewGameStrategy {

    @Override
    public boolean newGame(Deck deck, Dealer dealer, Player player) {
        if (deck == null || dealer == null || player == null) {
            return false; // Fail if any parameter is null
        }

        deck.shuffle();
        dealer.dealCard(deck.draw());
        dealer.dealCard(deck.draw());
        player.dealCard(deck.draw());
        player.dealCard(deck.draw());

        return true; // Game setup succeeded
    }
}
