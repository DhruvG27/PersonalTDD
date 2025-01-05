package org;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.strategies.*;

class RulesFactoryTest {

    @Test
    void testDefaultRules() {
        RulesFactory factory = new RulesFactory();
        HitStrategy hitStrategy = factory.getHitStrategy();

        assertNotNull(factory.getHitStrategy(), "Default HitStrategy should not be null.");
        assertNotNull(factory.getGameWinStrategy(), "Default GameWinStrategy should not be null.");
        assertNotNull(factory.getNewGameStrategy(), "Default NewGameStrategy should not be null.");
    }

    @Test
    void testCustomRules() {
        HitStrategy customHitStrategy = new Soft17HitStrategy();
        GameWinStrategy customGameWinStrategy = new PlayerWinsOnTieStrategy();
        NewGameStrategy customNewGameStrategy = new InternationalNewGameStrategy();

        RulesFactory factory = new RulesFactory(customHitStrategy, customGameWinStrategy, customNewGameStrategy);

        assertEquals(customHitStrategy, factory.getHitStrategy(), "Factory should return the custom HitStrategy.");
        assertEquals(customGameWinStrategy, factory.getGameWinStrategy(), "Factory should return the custom GameWinStrategy.");
        assertEquals(customNewGameStrategy, factory.getNewGameStrategy(), "Factory should return the custom NewGameStrategy.");
    }
}