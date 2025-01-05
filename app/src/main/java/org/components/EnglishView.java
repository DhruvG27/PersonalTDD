package org.components;

import org.components.Player;
import org.components.Card;

import java.util.stream.Collectors;

public class EnglishView {

    public String renderPlayerHand(Player player) {
        return "Player's hand: " +
               player.getHand().stream()
                     .map(Card::toString)
                     .collect(Collectors.joining(", "));
    }
}
