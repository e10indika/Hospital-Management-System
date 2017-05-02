package se.ucsc.hsptl.assignment.data;

/**
 * Created by Indika on 4/29/2017.
 */
public abstract class EmployeeData<E extends EmployeeData>
{
  String employeeId = null;

  Name name = null;

  ContactData contactData = null;

  PersonData personData = null;

  void setEmployeeId(String employeeId)
  {
    this.employeeId = employeeId;
  }

  public E setName(Name name)
  {
    this.name = name;
    return (E) this;
  }

  public E setContactData(ContactData contactData)
  {
    this.contactData = contactData;
    return (E) this;
  }

  public E setPersonData(PersonData personData)
  {
    this.personData = personData;
    return (E) this;
  }

  public String getEmployeeId()
  {
    return employeeId;
  }

  public Name getName()
  {
    return name;
  }

  public ContactData getContactData()
  {
    return contactData;
  }

  public PersonData getPersonData()
  {
    return personData;
  }
}
