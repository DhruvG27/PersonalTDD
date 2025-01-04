package org.components;

import java.util.ArrayList;

import org.components.Person;
import org.enums.Value;

public class Player extends Person {

    public ArrayList<Card> hand;

    public Player() {
        hand = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void dealCard(Card card) {
        hand.add(card);
    }

    public void clearHand() {
        hand.clear();
    }

    public void showHand() {
        for (Card card : hand) {
            card.show();
        }
    }

    public boolean hasAce() {
        return hand.stream().anyMatch(card -> card.getValue() == Value.ACE);
    }

}
