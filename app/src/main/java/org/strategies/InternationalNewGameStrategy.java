package org.strategies;

import org.components.Deck;

public class InternationalNewGameStrategy implements NewGameStrategy {
    @Override
    public void setupNewGame(Deck deck) {
        deck.shuffle();
    }
}
