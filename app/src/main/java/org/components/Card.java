package org.components;

import org.enums.Suite;
import org.enums.Value;

public class Card {

  private final Value value;
  private final Suite suite;
  private boolean isHidden = true;

  public Card(Value value, Suite suite) {
    this.value = value;
    this.suite = suite;
  }

  public void show() {
    isHidden = false;
  }

  public void hide() {
    isHidden = true;
  }

  public boolean isHidden() {
    return isHidden;
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

    if (isHidden) {
      return "Hidden";
    }
      return value.getDisplayName() + " of " + suite.getDisplayName();
  }

  /*
   * this method compares two Card objects based on their Value and Suite.
   * Returns true only if both attributes are identical.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;

    Card card = (Card) obj;
    return value == card.value && suite == card.suite;
  }

  /*
   * This method ensures that HashSet correctly groups Card objects with the same
   * Value and Suite.
   * It returns a unique hash code based on the Card's Value and Suite.
   */

  @Override
  public int hashCode() {
    int result = value.hashCode();
    result = 31 * result + suite.hashCode();
    return result;
  }
}
