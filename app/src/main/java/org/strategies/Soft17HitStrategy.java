package org.strategies;

import org.components.Person;
import org.enums.Value;

public class Soft17HitStrategy implements HitStrategy {

    @Override
    public boolean shouldHit(Person person) {
        int score = person.calculateScore();
        boolean hasAce = person.getHand().stream()
                                .anyMatch(card -> card.getValue() == Value.ACE);

        return score == 17 && hasAce; // Soft 17 condition
    }
}
