package org.components.strategies;

import org.components.Person;

public class Soft17HitStrategy implements HitStrategy {
    @Override
    public boolean shouldHit(Person person) {
        return person.isSoft17();
    }
}
