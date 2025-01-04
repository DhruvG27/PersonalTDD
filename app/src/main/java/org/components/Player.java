package org.components;

import java.util.ArrayList;

import org.components.Person;
import org.enums.Value;

public class Player extends Person {


    public void showHand() {
        for (Card card : hand) {
            card.show();
        }
    }

    public boolean hasAce() {
        return hand.stream().anyMatch(card -> card.getValue() == Value.ACE);
    }

}
