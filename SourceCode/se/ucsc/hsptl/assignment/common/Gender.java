package se.ucsc.hsptl.assignment.common;

/**
 * Created by Indika on 6/4/2017.
 */
public enum Gender
{
  MALE('M', "Male"), FEMALE('F', "Female"), OTHER('O', "Other");

  private final char character;
  private final String visibleString;

  Gender(char c, String string)
  {
    this.character = c;
    this.visibleString = string;
  }

  public char getChar()
  {
    return character;
  }
}
