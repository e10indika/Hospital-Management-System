package se.ucsc.hsptl.assignment.common;

/**
 * Created by Indika on 6/4/2017.
 */
public enum PersonTitle
{
  MR("Mr."), MISS("Miss."), MRS("Mrs."), VEN("Ven");

  private final String title;

  PersonTitle(String title)
  {
    this.title = title;
  }

  public String getTitle()
  {
    return this.title;
  }
}
