package org.components;

import java.util.ArrayList;
import java.util.List;

import org.enums.Value;

public abstract class Person {
    protected List<Card> hand;

    public Person() {
        hand = new ArrayList<>();
    }

    public int calculateScore() {
        int score = 0;
        boolean hasAce = false;

        for (Card card : hand) {
            score += card.getScore();
            if (card.getValue() == Value.ACE) hasAce = true;
        }

        if (score > 21 && hasAce) score -= 10;

        return score;
    }

    public abstract void dealCard(Card card);
}
