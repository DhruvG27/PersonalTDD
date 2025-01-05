package org.strategies;

import org.components.Person;

public class PlayerWinsOnTieStrategy implements GameWinStrategy {
    @Override
    public String determineWinner(Person dealer, Person player) {
        int dealerScore = dealer.calculateScore();
        int playerScore = player.calculateScore();

        if (playerScore > 21) return "Dealer"; // Player bust
        if (dealerScore > 21) return "Player"; // Dealer bust
        if (playerScore > dealerScore) return "Player";
        if (dealerScore > playerScore) return "Dealer";
        return "Player"; // Player wins on tie
    }
}
