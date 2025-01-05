package org.components;

import org.components.Player;
import org.components.Card;

import java.util.stream.Collectors;

public class EnglishView {

    public String renderHand(String name, Player player) {
        // Reveal all cards in the hand
        player.getHand().forEach(Card::show);
    
        // Render the hand
        return name + "'s hand: " +
               player.getHand().stream()
                     .map(Card::toString)
                     .collect(Collectors.joining(", "));
    }

    public String renderPlayerHand(Player player) {
        return renderHand("Player", player);
    }
    
}
