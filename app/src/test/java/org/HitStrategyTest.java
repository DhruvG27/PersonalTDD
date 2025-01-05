package org;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.components.*;
import org.strategies.*;

class HitStrategyTest {

    @Test
    void testSoft17Hit() {
        HitStrategy strategy = new Soft17HitStrategy();
        Person dealer = new Dealer();
        
        dealer.dealCard(new Card(Value.SIX, Suite.HEARTS));
        dealer.dealCard(new Card(Value.ACE, Suite.SPADES));

        assertTrue(strategy.shouldHit(dealer), "Dealer should hit on a soft 17.");
    }