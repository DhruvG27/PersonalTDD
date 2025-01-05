package org;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.strategies.*;

class RulesFactoryTest {

    @Test
    void testDefaultRules() {
        RulesFactory factory = new RulesFactory();
        HitStrategy hitStrategy = factory.getHitStrategy();
        GameWinStrategy winStrategy = factory.getGameWinStrategy();
        NewGameStrategy newGameStrategy = factory.getNewGameStrategy();

        assertNotNull(hitStrategy, "Hit strategy should not be null.");
        assertNotNull(winStrategy, "Game win strategy should not be null.");
        assertNotNull(newGameStrategy, "New game strategy should not be null.");
    }

    @Test
    void testCustomRules() {
        RulesFactory factory = new RulesFactory(
            new Soft17HitStrategy(),
            new DealerWinsOnTieStrategy(),
            new AmericanNewGameStrategy()
        );

        assertTrue(factory.getHitStrategy() instanceof Soft17HitStrategy, "Factory should return correct HitStrategy.");
        assertTrue(factory.getGameWinStrategy() instanceof DealerWinsOnTieStrategy, "Factory should return correct GameWinStrategy.");
        assertTrue(factory.getNewGameStrategy() instanceof AmericanNewGameStrategy, "Factory should return correct NewGameStrategy.");
    }
}