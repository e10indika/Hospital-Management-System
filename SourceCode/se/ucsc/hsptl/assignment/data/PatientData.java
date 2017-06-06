package se.ucsc.hsptl.assignment.data;

/**
 * Created by Pathum on 4/29/2017.
 */
public class PatientData implements Data
{
  PersonData personData;
  Name name;
  ContactData contactData;
  private String patientId;
  private String bloodGroup;

  public PatientData setPatientId(String patientId)
  {
    this.patientId = patientId;
    return this;
  }

  public PatientData(String patientId)
  {
    this.patientId = patientId;
  }

  public PatientData(String patientId, PersonData personData, Name name, ContactData contactData)
  {
    this.patientId = patientId;
    this.personData = personData;
    this.name = name;
    this.contactData = contactData;
  }

  public PersonData getPersonData()
  {
    return personData;
  }

  public PatientData setPersonData(PersonData personData)
  {
    this.personData = personData;
    return this;
  }

  public Name getName()
  {
    return name;
  }

  public PatientData setName(Name name)
  {
    this.name = name;
    return this;
  }

  public ContactData getContactData()
  {
    return contactData;
  }

  public PatientData setContactData(ContactData contactData)
  {
    this.contactData = contactData;
    return this;
  }

  public String getPatientId()
  {
    return patientId;
  }

  public String getBloodGroup()
  {
    return bloodGroup;
  }

  public void setBloodGroup(String bloodGroup)
  {
    this.bloodGroup = bloodGroup;
  }
}
