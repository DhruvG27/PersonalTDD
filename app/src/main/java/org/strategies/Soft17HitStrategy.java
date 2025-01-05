package org.strategies;

import org.components.Person;
import org.enums.Value;

public class Soft17HitStrategy implements HitStrategy {

    @Override
    public boolean shouldHit(Person person) {
        return person.isSoft17();
    }
}
