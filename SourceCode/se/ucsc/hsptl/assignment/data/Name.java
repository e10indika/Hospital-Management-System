package se.ucsc.hsptl.assignment.data;

/**
 * Created by Pathum on 4/29/2017.
 */
public class Name
{
  private static final char SPACE = ' ';
  private static final String DOT_SPACE = ". ";
  private static final char DOT = '.';

  private String firstName;
  private String middleName;
  private String lastName;
  private String title;
  private String formattedName;
  private String presentationName;

  public Name(String firstName, String middleName, String lastName, String title)
  {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.title = title;
    setFormattedName();
    setPresentationName();
  }

  public String getFirstName()
  {
    return firstName;
  }

  public Name setFirstName(String firstName)
  {
    this.firstName = firstName;
    return this;
  }

  public String getMiddleName()
  {
    return middleName;
  }

  public Name setMiddleName(String middleName)
  {
    this.middleName = middleName;
    return this;
  }

  public String getLastName()
  {
    return lastName;
  }

  public Name setLastName(String lastName)
  {
    this.lastName = lastName;
    return this;
  }

  public String getTitle()
  {
    return title;
  }

  public Name setTitle(String title)
  {
    this.title = title;
    return this;
  }

  public String getFormattedName()
  {
    return formattedName;
  }

  public String getPresentationName()
  {
    return presentationName;
  }

  private void setFormattedName()
  {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(firstName).append(SPACE).append(middleName).append(SPACE).append(lastName);

    this.formattedName = stringBuffer.toString();
  }

  private void setPresentationName()
  {
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(title).append(SPACE).append(lastName.toUpperCase()).append(SPACE)
      .append(firstName.toUpperCase().charAt(0)).append(DOT_SPACE).append(middleName.toUpperCase().charAt(0))
      .append(DOT);

    this.presentationName = stringBuffer.toString();
  }
}
