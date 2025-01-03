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
    void testDealerInitialization() {
        Dealer dealer = new Dealer();

        // Dealer should have an empty hand initially
        assertTrue(dealer.getHand().isEmpty(), "Dealer should start with an empty hand.");
    }

    @Test
    void testDealerDealsCardToSelf() {
        Dealer dealer = new Dealer();
        Card card = new Card(Value.ACE, Suite.HEARTS);

        dealer.dealCard(card);

        // Dealer's hand should contain the card
        assertEquals(1, dealer.getHand().size(), "Dealer's hand should contain one card.");
        assertTrue(dealer.getHand().contains(card), "Dealer's hand should contain the dealt card.");
    }

}
