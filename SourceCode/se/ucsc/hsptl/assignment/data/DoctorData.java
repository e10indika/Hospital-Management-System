package se.ucsc.hsptl.assignment.data;

/**
 * Created by Pathum on 4/29/2017.
 */
public class DoctorData extends EmployeeData implements Data
{
  private String doctorId;

  private String designation;

  public DoctorData(String doctorId,
                    String designation,
                    Name name,
                    ContactData contactData,
                    PersonData personData,
                    String employeeId)
  {
    super(employeeId, name, contactData, personData);
    this.doctorId = doctorId;
    this.designation = designation;
  }

  public String getDoctorId()
  {
    return doctorId;
  }

  public DoctorData setDoctorId(String doctorId)
  {
    this.doctorId = doctorId;
    return this;
  }

  public String getDesignation()
  {
    return designation;
  }

  public DoctorData setDesignation(String designation)
  {
    this.designation = designation;
    return this;
  }

  public DoctorData setEmployeeData(EmployeeData employeeData)
  {
    this.name = employeeData.getName();
    this.contactData = employeeData.getContactData();
    this.personData = employeeData.getPersonData();
    return this;
  }
}
