package org.components;

import java.util.ArrayList;
import java.util.List;

import org.enums.Value;

public abstract class Person {
    protected List<Card> hand;

    public Person() {
        hand = new ArrayList<>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public void dealCard(Card card) {
        hand.add(card);
    }

    public int calculateScore() {
        int score = 0;
        boolean hasAce = false;

        for (Card card : hand) {
            score += card.getValue().getScore();
            if (card.getValue() == Value.ACE) hasAce = true;
        }

        if (score > 21 && hasAce) score -= 10;

        return score;
    }

    public void clearHand() {
        System.out.println("Clearing hand...");
        hand.clear();
    }

    // Consolidated logic to check for soft 17
    public boolean isSoft17() {
        int score = calculateScore();
        boolean hasAce = hand.stream().anyMatch(card -> card.getValue() == Value.ACE);
        return score == 17 && hasAce;
    }
}
