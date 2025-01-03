package org.components;

import org.checkerframework.checker.units.qual.C;
import org.enums.Suite;
import org.enums.Value;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();

        // fixing the deck implementation to have 52 unique cards
        for (Suite suite : Suite.values()) {
            for (Value value : Value.values()) {
                cards.add(new Card(value, suite));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    // Adding the addCard method to add a card to the deck and check if the card is already in the deck
    // card is null, return false
    public boolean addCard(Card card) {
        if (cards.contains(card) || card == null) {
            return false;
        }
        cards.add(card);
        return true;

    }

    // Adding the drawCard method to draw a card from the deck and remove it from the deck
    // if the deck is empty, return null
    public Card drawCard(){
        if(cards.size() == 0){
            return null;
        }
        return cards.remove(0);
    }

    // Adding correct implementation of deck with 52 unique cards and no identical
    // cards to see all tests pass.

    // Now making the shuffle method to swap every second card with the card that
    // comes after it (if possible).
    public void shuffle() {
        for (int i = 0; i < cards.size(); i++) {

            int swapIndex = (int) (Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(swapIndex));
            cards.set(swapIndex, temp);
        }
    }

}
