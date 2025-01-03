package org.components;

import java.util.ArrayList;
import java.util.List;

import org.enums.Value;

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

    public void drawCards(Deck deck) {
        while (calculateScore() < 17) {
            Card card = deck.drawCard();
            if (card == null) break; // Stop if deck is empty
            dealCard(card);
        }
    }
    
    public int calculateScore() {
        int score = 0;
        boolean hasAce = false;
    
        for (Card card : hand) {
            score += card.getScore();
            if (card.getValue() == Value.ACE) hasAce = true;
        }
    
        // Adjust for ACE if score exceeds 21
        if (score > 21 && hasAce) score -= 10;
    
        return score;
    }
}    
