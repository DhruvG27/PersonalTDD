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

    public String revealCard() {
        if (hand.isEmpty()) {
            return "No cards to reveal";
        }
        Card lastCard = hand.get(hand.size() - 1);
        lastCard.show(); // Make the card visible
        return lastCard.toString(); // Return the string representation of the card
    }
    
    public void resetHand() {
        hand.clear();
    }

    public String determineWinner(Player player) {
        int dealerScore = calculateScore();
        int playerScore = player.calcScore();
    
        if (playerScore > 21) return "Dealer"; // Player bust
        if (dealerScore > 21) return "Player"; // Dealer bust
        if (playerScore > dealerScore) return "Player";
        if (dealerScore > playerScore) return "Dealer";
        return "Draw";
    }
    
    
    
}    
