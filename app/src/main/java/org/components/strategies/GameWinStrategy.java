package org.components.strategies;

import org.components.Dealer;
import org.components.Player;

public interface GameWinStrategy {
    String determineWinner(Dealer dealer, Player player);
}
