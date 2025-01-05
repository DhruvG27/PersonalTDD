package org.components.strategies;

import org.components.Person;

public class BasicHitStrategy implements HitStrategy {
    @Override
    public boolean shouldHit(Person person) {
        return person.calculateScore() < 17;
    }
}
