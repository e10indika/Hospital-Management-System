package se.ucsc.hsptl.assignment.data;

/**
 * Created by Indika on 4/29/2017.
 */
public abstract class EmployeeData<E extends EmployeeData> implements Data
{
  String employeeId = null;

  Name name = null;

  ContactData contactData = null;

  PersonData personData = null;

  public EmployeeData(String employeeId, Name name, ContactData contactData, PersonData personData)
  {
    this.employeeId = employeeId;
    this.name = name;
    this.contactData = contactData;
    this.personData = personData;
  }

  public String getEmployeeId()
  {
    return employeeId;
  }

  void setEmployeeId(String employeeId)
  {
    this.employeeId = employeeId;
  }

  public Name getName()
  {
    return name;
  }

  public E setName(Name name)
  {
    this.name = name;
    return (E) this;
  }

  public ContactData getContactData()
  {
    return contactData;
  }

  public E setContactData(ContactData contactData)
  {
    this.contactData = contactData;
    return (E) this;
  }

  public PersonData getPersonData()
  {
    return personData;
  }

  public E setPersonData(PersonData personData)
  {
    this.personData = personData;
    return (E) this;
  }
}
