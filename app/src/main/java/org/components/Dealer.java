package org.components;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private final List<Card> hand;

    public Dealer() {
        this.hand = new ArrayList<>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public void dealCard(Card card) {
        hand.add(card);
    }
}
