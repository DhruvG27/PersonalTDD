package org;

import static org.junit.jupiter.api.Assertions.*;

import org.components.strategies.*;
import org.junit.jupiter.api.Test;

class RulesFactoryTest {

    @Test
    void testDefaultHitStrategy() {
        RulesFactory factory = new RulesFactory();

        assertNotNull(factory.getHitStrategy(), "Default HitStrategy should not be null.");
        assertTrue(factory.getHitStrategy() instanceof Soft17HitStrategy, 
            "Default HitStrategy should be an instance of Soft17HitStrategy.");
    }

    @Test
    void testCustomHitStrategy() {
        HitStrategy customStrategy = new HitStrategy() {
            @Override
            public boolean shouldHit(org.components.Person person) {
                return false; // Custom logic for testing
            }
        };

        RulesFactory factory = new RulesFactory(customStrategy);

        assertEquals(customStrategy, factory.getHitStrategy(), 
            "Factory should return the custom HitStrategy.");
    }

    @Test
    void testNullCustomHitStrategy() {
        RulesFactory factory = new RulesFactory(null);

        assertNotNull(factory.getHitStrategy(), "HitStrategy should not be null when null is passed.");
        assertTrue(factory.getHitStrategy() instanceof Soft17HitStrategy, 
            "Factory should default to Soft17HitStrategy when null is passed.");
    }
}