package se.ucsc.hsptl.assignment.common;

/**
 * Created by Pathum on 6/6/2017.
 */
public enum AttendanceType
{
  IN(1), OUT(0);

  private final int value;

  AttendanceType(int value)
  {
    this.value = value;
  }

  public int getValue()
  {
    return value;
  }
}
