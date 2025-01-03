package org.components;

import java.util.ArrayList;

import org.enums.Value;

public class Player {

    public ArrayList<Card> hand;

    public Player() {
        hand = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void dealCard(Card c) {
        hand.add(c);
    }

    public void clearHand() {
        hand.clear();
    }

    public void showHand() {
        for (Card c : hand) {
            c.show();;
        }
    }

    public boolean hasAce() {
        for (Card c : hand) {
            if (c.getValue() == Value.ACE) {
                return true;
            }
        }
        return false;

    }

    public int calcScore() {

        int score = 0;
        for (Card c : hand) {
            score += c.getScore();
        }

        if (score > 21 && hasAce()) {
            score -= 10;
        }

        return score;
    }

}
