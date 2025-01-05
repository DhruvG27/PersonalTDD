package org;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.components.*;
import org.components.strategies.*;
import org.enums.Suite;
import org.enums.Value;

class HitStrategyTest {

    @Test
    void testSoft17Hit() {
        HitStrategy strategy = new Soft17HitStrategy();
        Person dealer = new Dealer();
        
        dealer.dealCard(new Card(Value.SIX, Suite.HEARTS));
        dealer.dealCard(new Card(Value.ACE, Suite.SPADES));

        assertTrue(strategy.shouldHit(dealer), "Dealer should hit on a soft 17.");
    }

    @Test
    void testHard17NoHit() {
        HitStrategy strategy = new Soft17HitStrategy();
        Person dealer = new Dealer();
        
        dealer.dealCard(new Card(Value.SEVEN, Suite.CLUBS));
        dealer.dealCard(new Card(Value.TEN, Suite.DIAMONDS));

        assertFalse(strategy.shouldHit(dealer), "Dealer should not hit on a hard 17.");
    }
}