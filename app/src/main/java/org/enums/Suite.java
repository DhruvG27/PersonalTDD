package org.enums;

public enum Suite {
  SPADES("Spades"),
  HEARTS("Hearts"),
  CLUBS("Clubs"),
  DIAMONDS("Diamonds");

  private final String displayName;

  Suite(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }

}
