package org;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.components.Card;
import org.components.Dealer;
import org.components.Player;
import org.components.Person;
import org.enums.Suite;
import org.enums.Value;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    void testPersonCalculateScore() {
        // Create a concrete subclass for testing
        Person person = new Person() {
            @Override
            public void dealCard(Card card) {
                hand.add(card);
            }
        };

        person.dealCard(new Card(Value.TEN, Suite.HEARTS));
        person.dealCard(new Card(Value.ACE, Suite.SPADES));

        int score = person.calculateScore();

        assertEquals(21, score, "Score calculation should handle ACE as 11 correctly.");
    }

    @Test
    void testPersonClearHand() {
        Person person = new Person() {
        };
        Card card = new Card(Value.ACE, Suite.SPADES);
        person.dealCard(card);
        assertEquals(1, person.getHand().size(), "Hand should contain 1 card before clearing.");
        person.clearHand();
        assertTrue(person.getHand().isEmpty(), "Hand should be empty after clearing.");
    }

}
