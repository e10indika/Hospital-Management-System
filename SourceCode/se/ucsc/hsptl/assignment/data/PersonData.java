package se.ucsc.hsptl.assignment.data;

import java.util.Date;

/**
 * Created by Pathum on 4/29/2017.
 */
public class PersonData
{
  private String gender;
  private Date birthDate;
  private String nationality;

  public PersonData()
  {
  }

  public PersonData(String gender, Date birthDate, String nationality)
  {
    this.gender = gender;
    this.birthDate = birthDate;
    this.nationality = nationality;
  }

  public String getGender()
  {
    return gender;
  }

  public PersonData setGender(String gender)
  {
    this.gender = gender;
    return this;
  }

  public Date getBirthDate()
  {
    return birthDate;
  }

  public PersonData setBirthDate(Date birthDate)
  {
    this.birthDate = birthDate;
    return this;
  }

  public String getNationality()
  {
    return nationality;
  }

  public PersonData setNationality(String nationality)
  {
    this.nationality = nationality;
    return this;
  }
}
