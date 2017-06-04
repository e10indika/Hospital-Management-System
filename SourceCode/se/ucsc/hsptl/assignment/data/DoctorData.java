package se.ucsc.hsptl.assignment.data;

/**
 * Created by Indika on 4/29/2017.
 */
public class DoctorData extends EmployeeData implements Data
{
  private String doctorId;

  private String designation;

  public DoctorData(String doctorId, String employeeId)
  {
    setEmployeeId(employeeId);

    this.doctorId = doctorId;
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
}
