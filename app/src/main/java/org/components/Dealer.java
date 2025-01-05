package org.components;

import java.util.ArrayList;
import java.util.List;

import org.components.Person;
import org.enums.Value;

public class Dealer extends Person {


    public Dealer() {
        this.hand = new ArrayList<>();
    }

    public void drawCards(Deck deck) {
        while (calculateScore() < 17) {
            Card card = deck.drawCard();
            if (card == null) break;
            dealCard(card);
        }
    }
    

    public String revealCard() {
        if (hand.isEmpty()) {
            return "No cards to reveal";
        }
        Card lastCard = hand.get(hand.size() - 1);
        lastCard.show(); // Make the card visible
        return lastCard.toString(); // Return the string representation of the card
    }

    public String determineWinner(Player player) {
        int dealerScore = calculateScore();
        int playerScore = player.calculateScore();
    
        if (playerScore > 21) return "Dealer"; // Player bust
        if (dealerScore > 21) return "Player"; // Dealer bust
        if (playerScore > dealerScore) return "Player";
        if (dealerScore > playerScore) return "Dealer";
        return "Draw";
    }

    @Override
    public void dealCard(Card card) {
        if (card != null) { // Prevent adding null cards
            hand.add(card);
        }
    }

    public void resetHand() {
        hand.clear();
    }

    @Override
    public int calculateScore() {
        return super.calculateScore();
    }   
    
    
}    
