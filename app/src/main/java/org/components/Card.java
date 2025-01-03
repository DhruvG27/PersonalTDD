package org.components;

import org.enums.Suite;
import org.enums.Value;

public class Card {

  private boolean hidden = true;
  private Value value;
  private Suite suite;

  public Card(Value value, Suite suite) {
    this.suite = suite;
    this.value = value;
  }

  public boolean isHidden() {
    return hidden;
  }

  public void show() {
    hidden = false;
  }

  public Value getValue() {
    return value;
  }

  public Suite getSuite() {
    return suite;
  }

  public int getScore() {
    return value.getScore();
  }

  @Override
  public String toString() {

    if (!hidden) {
      return value.getDisplayName() + " of " + suite.getDisplayName();
    }

    return "Hidden";
  }
  
  /*
   * this method compares two Card objects based on their Value and Suite.
   * Returns true only if both attributes are identical.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;

    Card card = (Card) obj;
    return value == card.value && suite == card.suite;
  }

  /*
   * This method ensures that HashSet correctly groups Card objects with the same Value and Suite.
   * It returns a unique hash code based on the Card's Value and Suite.
   */
   
  @Override
  public int hashCode() {
    int result = value.hashCode();
    result = 31 * result + suite.hashCode();
    return result;
  }
}
