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
        // Ensure all cards in the player's hand are visible
        player.getHand().forEach(Card::show);
    
        // Render the player's hand
        return "Player's hand: " +
               player.getHand().stream()
                     .map(Card::toString)
                     .collect(Collectors.joining(", "));
    }
    

    public String renderDealerHand(Dealer dealer) {
        // Ensure only the first card is visible
        for (int i = 0; i < dealer.getHand().size(); i++) {
            if (i == 0) {
                dealer.getHand().get(i).show();
            } else {
                dealer.getHand().get(i).hide();
            }
        }
    
        // Render the dealer's hand
        return "Dealer's hand: " +
               dealer.getHand().stream()
                     .map(Card::toString)
                     .collect(Collectors.joining(", "));
    }
    
    
    
}
