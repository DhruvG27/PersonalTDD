package org;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.components.Card;
import org.components.Dealer;
import org.enums.Suite;
import org.enums.Value;
import org.junit.jupiter.api.Test;

public class DealerTest {

    @Test
    void testDealerInitialisation() {
        Dealer dealer = new Dealer();
        Card c = new Card(Value.ACE, Suite.SPADES);

        // dealer should have an empty hand at the begining
        assertTrue(dealer.getHand().isEmpty());

        dealer.dealCard(c);

        // dealer should have one card in hand after dealing
        assertEquals(dealer.getHand().size(), 1);
    }
    
}
