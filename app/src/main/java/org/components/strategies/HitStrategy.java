package org.components.strategies;

import org.components.Person;

public interface HitStrategy {
    boolean shouldHit(Person person);
}
