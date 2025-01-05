package org.components.strategies;

import org.components.Dealer;
import org.components.Player;

public class PlayerWinsOnTieStrategy implements GameWinStrategy {

    @Override
    public String determineWinner(Dealer dealer, Player player) {
        int dealerScore = dealer.calculateScore();
        int playerScore = player.calculateScore();

        if (playerScore > 21) return "Dealer"; // Player busts
        if (dealerScore > 21) return "Player"; // Dealer busts
        if (playerScore > dealerScore) return "Player";
        if (dealerScore > playerScore) return "Dealer";
        return "Player"; // Player wins on tie
    }
}
